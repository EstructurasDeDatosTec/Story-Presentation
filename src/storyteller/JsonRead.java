
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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;



public class JsonRead {
    
    private ApiCall photoAnalize;
    
    public void photoLinks(String pJsonPath) throws URISyntaxException
     {
        JSONParser parser = new JSONParser(); 
                try {
            Object obj = parser.parse(new FileReader(pJsonPath));

            JSONObject jsonObject = (JSONObject) obj;
            // loop in array of photo urls
            JSONArray tags = (JSONArray) jsonObject.get("Urls");
            Iterator<String> iterator = tags.iterator();
            photoAnalize = new ApiCall();
            while (iterator.hasNext()) {
                String URL = iterator.next();
                 photoAnalize.photoAnalize(URL);
               
            }
             photoAnalize.debuggerTree();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
     }

    public ApiCall getPhotoAnalize() {
        return photoAnalize;
    }

    public void setPhotoAnalize(ApiCall photoAnalize) {
        this.photoAnalize = photoAnalize;
    }
     
    
    
    
}
