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


public class ApiCall {
    
    private HttpEntity entity;

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
                        String[] name = a.get(i).toString().split(",");
                        String[] tagName = name[1].split(":");
                       
                        String v = tagName[1];
                        v = EliminaCaracteres(v,"}");
                        
                        System.out.println(v);
                    }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public String EliminaCaracteres(String s_cadena, String s_caracteres)
{
  String nueva_cadena = "";
  Character caracter = null;
  boolean valido = true;
 
  /* Va recorriendo la cadena s_cadena y copia a la cadena que va a regresar,
     sólo los caracteres que no estén en la cadena s_caracteres */
  for (int i=0; i<s_cadena.length(); i++)
      {
       valido = true;
       for (int j=0; j<s_caracteres.length(); j++)
           {
            caracter = s_caracteres.charAt(j);
 
            if (s_cadena.charAt(i) == caracter)
               {
                valido = false;
                break;
               }
           }
       if (valido)
           nueva_cadena += s_cadena.charAt(i);
      }
 
  return nueva_cadena;
}
    
   /* public  ArrayList<HashMap> Tags() throws IOException
    {
        String File = EntityUtils.toString(entity);
        ArrayList<HashMap> Tags  = new ArrayList<HashMap>();
        JSONObject c = (JSONObject) entity;
        ArrayList<HashMap> a = (ArrayList<HashMap>) c.get("tags");
        for(HashMap i :a)
        {
            System.out.println(i.toString());
        }
        return Tags;
    }
    
    */
    

    
}
