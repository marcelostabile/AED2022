import java.util.LinkedList;

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
            if ((caracter >= 'A' && caracter <= 'Z')
                    || (caracter >= 'a' && caracter <= 'z')) {
                sb.append(caracter);
            }
        }
        return sb.toString().toLowerCase();
    }
    
    public static void main(String[] args) {

        int lineasPorPagina = 50;

        // desarrollar el programa para armar el índice del libro
        
        // TRIE INDICE
        TArbolTrie trieIndice = new TArbolTrie();
        
        // INSERTAR PALABRAS EN EL INDICE
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\palabrasdelindice.txt");
        for (String i:palabras){
            trieIndice.insertar(filtrarPalabra(i));
        }
        
        // LEER LIBRO
        String[] libro = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\librotexto.txt");
        
        // OBTENER LAS PALABRAS DE CADA LINEA
        for (int nroLinea = 0; nroLinea <= libro.length-1; nroLinea++) {
            String l = libro[nroLinea].toString();
            String[] linea = l.split(" ");
            int nroPagina = (int) (nroLinea / 50);
            
            // PARA CADA PALABRA, LA BUSCO EN EL INDICE E INSERTO NRO PAGINA
            for (String palabra : linea) {
                TNodoTrie miNodo = trieIndice.buscar(filtrarPalabra(palabra));
                miNodo.insertarPagina(nroPagina);
            }
        }
        
        // IMPRIMIR INDICE CON PALABRA, OCURRENCIAS, PAGINAS.
        trieIndice.imprimir();

    }

}
