/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Indice {

    /**
     * @param args the command line arguments
     */
    public static String filtrarPalabra(String unaPalabra) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < unaPalabra.length(); i++) {
			char caracter = unaPalabra.charAt(i);
			if ((caracter >= 'A' && caracter <= 'Z') ||
					(caracter >= 'a' && caracter <= 'z'))
				sb.append(caracter);
		}
		return sb.toString().toLowerCase();
    }
    
    public static void main(String[] args) {
        
        int lineasPorPagina = 50;
        
        
        
        // desarrollar el programa para armar el índice del libro
        
       
    }
    
    
}
