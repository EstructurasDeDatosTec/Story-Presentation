
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
    
 
    
    
    public void photoLinks(String i)
     {
        JSONParser parser = new JSONParser(); 
                try {
            Object obj = parser.parse(new FileReader(i));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            // loop array
            JSONArray tags = (JSONArray) jsonObject.get("Urls");
            Iterator<String> iterator = tags.iterator();
            ApiCall api = new ApiCall();
        
            while (iterator.hasNext()) {
                String pene = iterator.next();
                System.out.println(pene);
                api.photoAnalize(pene);
               
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
