/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albums;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author albertoobando
 */
public class AlbumSelector implements Serializable{
    
    private ArrayList<AlbumIndex> List = new ArrayList<AlbumIndex>();
    
    //Constructor
    public AlbumSelector(){
        
    } 
    
    //QuickSort
    /**
     * Funcion para ordenar la lista de menor a mayor
     * @param lowerIndex indice mas bajo
     * @param higherIndex indice mas grande
     */
    private void quickSort(int lowerIndex, int higherIndex) {

    int low = lowerIndex;
    int high = higherIndex;

    // Se toma como pivote el elemento del medio
    AlbumIndex pivot = List.get(lowerIndex+(higherIndex-lowerIndex)/2);

    // Se divide en dos listas
    while (low <= high) {

        while (List.get(low).getKey().compareTo(pivot.getKey()) < 0) {
            low++;
        }

        while (List.get(high).getKey().compareTo(pivot.getKey()) > 0) {
            high--;
        }

        if (low <= high) {
            exchangeNumbers(low, high);
            //move index to next position on both sides
            low++;
            high--;
        }
    }
        // Si no se ha terminado de ordenar se llama recursivamente
        if (lowerIndex < high)
            quickSort(lowerIndex, high);
        if (low < higherIndex)
            quickSort(low, higherIndex);
    }
 
    /**
     * Funcion para intercambiar dos Albums
     * @param num1 posicion del Album por cambiar
     * @param num2 posicion del Album con el cual se hara el cambio
     */
    private void exchangeNumbers(int num1, int num2) {
        AlbumIndex temp = List.get(num1);
        List.set(num1, List.get(num2));
        List.set(num2, temp);
    }
    
    //Binary Search, obtiene el indice del dato
    public int binarySearch(String dato) {
        int inicio = 0;
        int fin = List.size() - 1;
        int pos;
        
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( List.get(pos).getKey().equals(dato) ){ //Si lo encuentra
              return pos;
            }
            else if ( List.get(pos).getKey().compareTo(dato) < 0 ) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return - 1;
    }
    
    //Busqueda y devolucion de un album existente
    public AlbumIndex SearchAndGet(String dato) {
        int inicio = 0;
        int fin = List.size() - 1;
        int pos;
        
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( List.get(pos).getKey().equals(dato) ){ //Si lo encuentra
              return List.get(pos);
            }
            else if ( List.get(pos).getKey().compareTo(dato) < 0 ) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return null; //Si no lo encuentra
    }
    
    //Busqueda de un album existente
    public boolean Search(String dato) {
        int inicio = 0;
        int fin = List.size() - 1;
        int pos;
        
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( List.get(pos).getKey().equals(dato) ){ //Si lo encuentra
              return true;
            }
            else if ( List.get(pos).getKey().compareTo(dato) < 0 ) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return false; //Si no lo encuentra
    }
    
    //Me devuelve un array con los nombres de los albumes guardados
    public ArrayList<String> getNames(){
        ArrayList<String> result = new ArrayList<String>();
        if (List.size() == 0){ //Caso para cuando esta vacia
            return null;
        }else if(List.size() == 1){ //Caso para cuando tiene un elemento
            result.add(List.get(0).getKey());
        }
        for (int i = 0; i < this.List.size() - 1; i++ ){ //Caso general
            result.add(List.get(i).getKey());
        }
        return result;
    }
    
    //Funcion para agregar un album nuevo
    public void addAlbum(Album pAlbum){
        //Ocupo poder accesar al absolut path del album, despues de guardarlo
        if (this.Search(pAlbum.getName())){
            //Decirle al usuario que el nombre ya existe
        }else{
            AlbumIndex albumAdd = new AlbumIndex(pAlbum.getName(), "");
            List.add(albumAdd);
            quickSort(0, List.size() - 1);
        }
    }
    
}
