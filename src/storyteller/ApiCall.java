package storyteller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tree.AVLTree;
import tree.ImageNode;


public class ApiCall {
    
    private HttpEntity entity;
    private AVLTree photoTree= new AVLTree();
    
    public void photoAnalize(String url) throws URISyntaxException, ParseException, IOException
    {
        HttpClient httpclient = new DefaultHttpClient();

            URIBuilder builder = new URIBuilder("https://eastus2.api.cognitive.microsoft.com/vision/v1.0/analyze"); 
            builder.setParameter("visualFeatures", "Description");
            builder.setParameter("language", "en");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers - replace this example key with your valid subscription key.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "cf86f75d31684af4b05e8a15fcf239ab");

            // Request body. Replace the example URL with the URL for the JPEG image of a celebrity.
            StringEntity reqEntity = new StringEntity("{\"url\":\""+url+"\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            entity = response.getEntity();
            String File = EntityUtils.toString(entity);
            ImageNode UrlImage = new ImageNode(url);

            if (entity != null)
            {
               ArrayList<HashMap> Tags  = new ArrayList<HashMap>();
               JSONParser parser = new JSONParser();
               JSONObject jsonFile = (JSONObject) parser.parse(File);
               JSONObject descriptions = (JSONObject) jsonFile.get("description");
                ArrayList<String> a = (ArrayList<String>) descriptions.get("tags");
                ArrayList<JSONObject> b = (ArrayList<JSONObject>) descriptions.get("captions");
                String captionText = (String) b.get(0).get("text");
                UrlImage.setDescription(captionText);
                for( int i=0; i<3;i++ )
                    {
                        String[] TagName = a.get(i).toString().split(",");
                        String FinalTag = TagName[0];
                        photoTree.insert(FinalTag, UrlImage);
                    }
            }
            
    }
    
    public void debuggerTree()
    {
        
        photoTree.inorder();
        photoTree.debugTree();
        photoTree.printTree();

    }
    
   public String deleteChar(String pString, String pChars)
    {
        String new_string = "";
        Character char_replace = null;
        boolean valide = true;


        for (int i=0; i<pString.length(); i++)
            {
             valide = true;
             for (int j=0; j<pChars.length(); j++)
                 {
                  char_replace = pChars.charAt(j);

                  if (pString.charAt(i) == char_replace)
                     {
                      valide = false;
                      break;
                     }
                 }
             if (valide)
                 new_string += pString.charAt(i);
            }

        return new_string;
    }
   
    public HttpEntity getFile() {
        return entity;
    }

 
    public AVLTree getPhotoTree() {
        return photoTree;
    }

    public void setPhotoTree(AVLTree photoTree) {
        this.photoTree = photoTree;
    }
    
    
}
