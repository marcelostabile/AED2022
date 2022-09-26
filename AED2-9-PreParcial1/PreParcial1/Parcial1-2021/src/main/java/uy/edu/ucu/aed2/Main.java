package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // INSTANCIAR UN TRIE
        TArbolTrie trie = new TArbolTrie();
        
        // LEER LA CADENA DE AMINOACIDOS DESDE EL ARCHIVO
        String[] secuencia = ManejadorArchivosGenerico.leerArchivo("./src/main/java/uy/edu/ucu/aed2/mensaje.txt");
        
        // GENERAR TODOS LOS SUFIJOS E INSERTARLOS EN EL TRIE, CUIDANDO DE REGISTRAR LA POSICIÓN 
        // DE INICIO DE CADA UNO
        for (String i : secuencia){
            trie.insertarSufijos(i);
        }

        trie.imprimir();
        
        // INVOCAR A  trie.encontrarPatron("110101") Y escribir los resultados en el archivo 
        // SALIDA.TXT
        LinkedList <Integer> lista1 = trie.encontrarPatron("110101");
        String [] salida = {lista1.toString()};
        ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/salida.txt", salida);
        
        
        // INVOCAR A  trie.encontrarPatron("110101") Y agregar los resultados en el archivo 
        // SALIDA.TXT
        LinkedList <Integer> lista2 = trie.encontrarPatron("1101011");
        String [] salida2 = {lista2.toString()};
        ManejadorArchivosGenerico.escribirArchivo("./src/main/java/uy/edu/ucu/aed2/salida.txt", salida2);
        
    }
}