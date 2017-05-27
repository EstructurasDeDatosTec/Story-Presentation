package albums;

import java.io.*;

public class RWFile implements Serializable{
	
    private Album _Album;
    private String _Archivo;
    private FileInputStream _FileInput;
    private BufferedInputStream _BufferedInput;
    private FileOutputStream _FileOutput;
    private BufferedOutputStream _BufferedOutput;
    private byte[] _Bytes = null;


    //Constructor

    public RWFile(String pArchivo){
        this._Archivo = pArchivo;
        this._Album = new Album();
    }

    //Funciones

    public void writeFile(byte[] pBytes){
        
        _Bytes = pBytes;
        try {
                _FileOutput = new FileOutputStream (_Archivo);
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        _BufferedOutput = new BufferedOutputStream(_FileOutput);
        
        try
        {
            _BufferedOutput.write(_Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                   _BufferedOutput.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

    public byte[] readFile(){
        try {
                _FileInput = new FileInputStream(_Archivo);
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                return null;
        }
        _BufferedInput = new BufferedInputStream(_FileInput);
         try {
             _Bytes = new byte[1000];
             _BufferedInput.read(_Bytes);
         }
         catch(Exception e){
             e.printStackTrace();
             return null;
         }finally{
                  try {
                      _BufferedInput.close();
                  } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                  }
         }
         return _Bytes;
    }

    //Setter y Getter

    public Album get_Album(){
        return this._Album;
    }

}