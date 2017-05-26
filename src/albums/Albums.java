/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albums;

import java.util.ArrayList;

/**
 *
 * @author albertoobando
 */
public class Albums {
    
    private ArrayList<Integer> list;
    
    /**
	 * Funcion para ordenar la lista de menor a mayor
	 * @param lowerIndex indice mas bajo
	 * @param higherIndex indice mas grande
	 */
	private void quickSort(int lowerIndex, int higherIndex) {
        
        int low = lowerIndex;
        int high = higherIndex;
        
        // Se toma como pivote el elemento del medio
        int pivot = list.get(lowerIndex+(higherIndex-lowerIndex)/2);
        
        // Se divide en dos listas
        while (low <= high) {
        	
            while (list.get(low) < pivot) {
                low++;
            }
            
            while (list.get(high) > pivot) {
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
	 * Funcion para intercambiar dos numeros
	 * @param num1 posicion del numero por cambiar
	 * @param num2 posicion del numero con el cual se hara el cambio
	 */
    private void exchangeNumbers(int num1, int num2) {
        int temp = list.get(num1);
        list.set(num1, list.get(num2));
        list.set(num2, temp);
    }
    
}
