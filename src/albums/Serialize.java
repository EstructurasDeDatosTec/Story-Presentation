package albums;

import java.io.*;

public class Serialize<e> {
	
    private RWFile _File;

    //Constructor 

    public Serialize(RWFile pFile){
        this._File = pFile;
    }

    //Funciones 

    public byte[] serializing(e pAlbum){
        ByteArrayOutputStream bs= new ByteArrayOutputStream();
        ObjectOutputStream os;
        try {
                os = new ObjectOutputStream (bs);
                os.writeObject(pAlbum);
                os.close();
        } catch (IOException e1) {
                e1.printStackTrace();
                return null;
        }
        return bs.toByteArray();
    }

    public e deserializing(byte[] bytes){
        ByteArrayInputStream bs= new ByteArrayInputStream(bytes);
        ObjectInputStream is;
        e objeto = null;
        try {
                is = new ObjectInputStream(bs);
                objeto = (e)is.readObject();
                is.close();
        } catch (IOException | ClassNotFoundException e1) {
                e1.printStackTrace();
        }

        return objeto;
    }

}