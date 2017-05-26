package storyteller;

import java.io.IOException;
import java.net.URI;
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


public class ApiCall {
    
    private HttpEntity entity;
    private AVLTree photoTree= new AVLTree();

    public HttpEntity getFile() {
        return entity;
    }

    public void setFile(HttpEntity pEntity) {
        entity = pEntity;
    }
    
    
    
    
    public void photoAnalize(String url)
    {
        HttpClient httpclient = new DefaultHttpClient();

        try
        {
            URIBuilder builder = new URIBuilder("https://eastus2.api.cognitive.microsoft.com/vision/v1.0/analyze");

            builder.setParameter("visualFeatures", "Tags");
            //builder.setParameter("visualFeatures", "Description");
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

            if (entity != null)
            {
               ArrayList<HashMap> Tags  = new ArrayList<HashMap>();
               JSONParser parser = new JSONParser();
               JSONObject jsonFile = (JSONObject) parser.parse(File);
                ArrayList<HashMap> a = (ArrayList<HashMap>) jsonFile.get("tags");
                for( int i=0; i<3;i++ )
                    {
                        String[] TagName = a.get(i).toString().split(",");
                        String[] MoreConfidence = TagName[1].split(":");
                       
                        String PhotoTags = MoreConfidence[1];
                        PhotoTags = deleteChar(PhotoTags,"}");
                        photoTree.insert(PhotoTags, url);
                        
                        //System.out.println(PhotoTags);
                    }
                   
            }
        }
        
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
         photoTree.inorder();
         System.out.println("\n");
    }
    
    
   public String deleteChar(String pString, String pChars)
    {
        String new_string = "";
        Character char_replace = null;
        boolean valide = true;

        /* Va recorriendo la cadena s_cadena y copia a la cadena que va a regresar,
           sólo los caracteres que no estén en la cadena s_caracteres */
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
   
    
}
