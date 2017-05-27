/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albums;

/**
 *
 * @author albertoobando
 */
public class AlbumIndex {
    
    private String Key; //Nombre y llave del album
    private String Path; //El absolut path del album
    
    //Constructor

    public AlbumIndex(String pKey, String pPath) {
        this.Key = pKey;
        this.Path = pPath;
    }
    
    
    //Getters y Setters

    public String getKey() {
        return Key;
    }

    public String getPath() {
        return Path;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }
    
    
    
    
    
}
