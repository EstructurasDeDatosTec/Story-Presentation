
package storyteller;

import java.io.File;
import storyteller.ApiCall;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



public class JsonRead { 
    
 
    
    
    public void photoLinks(String pJsonPath)
     {
        JSONParser parser = new JSONParser(); 
                try {
            Object obj = parser.parse(new FileReader(pJsonPath));

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);

            // loop in array of photo urls
            JSONArray tags = (JSONArray) jsonObject.get("Urls");
            Iterator<String> iterator = tags.iterator();
            ApiCall api = new ApiCall();
            while (iterator.hasNext()) {
                String URL = iterator.next();
               // System.out.println(URL);
                //Request Api call
                api.photoAnalize(URL);
               
            }
            
            
        

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
     }
     
    
}
