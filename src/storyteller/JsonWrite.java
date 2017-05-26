
package storyteller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class JsonWrite {
    
        public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba1.jpg");
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba2.jpg");
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba3.jpg");
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba4.jpg");
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba5.jpg");
        list.add("C:\\Users\\Joseph Salas\\Desktop\\Imagenes Story\\Prueba6.jpg");

        obj.put("Urls", list);

        try (FileWriter file = new FileWriter("C:\\Users\\Joseph Salas\\Desktop\\UrlsDefinitivo.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

    
}
