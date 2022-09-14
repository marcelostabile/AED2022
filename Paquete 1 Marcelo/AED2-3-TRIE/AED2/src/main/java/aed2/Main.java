package aed2;

import aed2.archivos.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Crear una instancia de arbol Trie.
        TArbolTrie trie = new TArbolTrie();
        
        // Insertar palabras en el Trie.
        trie.insertar("casa");
        trie.insertar("casamiento");
        //trie.insertar("caño");

        trie.insertar("arbol");
        trie.insertar("grito");
        trie.insertar("casa");

        trie.insertar("casamiento");
        trie.insertar("arbol");
        trie.insertar("grito");

        trie.insertar("arbol");
        trie.insertar("grito");
        trie.insertar("grito");

        // Imprimir por pantalla.
        trie.imprimir();
        
        // Impresión de ocurrencias de cada palabra.
        System.out.println("Ocurrencias de 'arbol': " + trie.buscar("arbol"));
        System.out.println("Ocurrencias de 'casa': " + trie.buscar("casa"));
        System.out.println("Ocurrencias de 'casamiento': " + trie.buscar("casamiento"));
        System.out.println("Ocurrencias de 'grito': " + trie.buscar("grito"));
        
        /****************/
        /* TRIE ARCHIVO */
        /****************/
        System.out.println("\nTRIE ARCHIVO\n");
        
        // Cargar el trie con palabras desde un archivo.
        String directorio = "src\\main\\java\\aed2\\archivos\\";
        
        String[] lineasArchivo = ManejadorArchivosGenerico.leerArchivo(directorio + "palabras1.txt");
        TArbolTrie trieArchivo = new TArbolTrie();
        for (String linea : lineasArchivo){
            trieArchivo.insertar(linea);
        }
        
        System.out.print("\nImpresión en Pre-Orden\n");
        
        trieArchivo.imprimir();
        
        /****************/
        /* TRIE PAGINAS */
        /****************/
        System.out.println("\nPÁGINAS\n");
        
        // Cargar un trie con palabras desde un archivo.
        String[] lineasArchivo2 = ManejadorArchivosGenerico.leerArchivo(directorio + "palabras-paginas.txt");
        TArbolTrie trieArchivo2 = new TArbolTrie();
        for (String linea : lineasArchivo2){
            trieArchivo2.insertarPaginas(linea);
        }

        System.out.print("\nImpresión en Pre-Orden\n");
        
        trieArchivo2.imprimir();
        
        /****************/
        /* PREDECIR     */
        /****************/
        System.out.println("\nPREDECIR\n");
        
        // Obtener lista de subfijos según prefijo ingresado.
        // Imprimir por pantalla los resultados.
        
        System.out.println("Predecir: ala");
        LinkedList <String> lista1 = trieArchivo2.predecir ("ala");
        System.out.println(lista1.toString());
        
        System.out.println("Predecir: pe");
        LinkedList <String> lista2 = trieArchivo2.predecir ("pe");
        System.out.println(lista2.toString());

        System.out.println("Predecir: pepe");
        LinkedList <String> lista3 = trieArchivo2.predecir ("pepe");
        System.out.println(lista3.toString());

        System.out.print("\n");
        
        // Caso 2
        String[] lineasPredecir = ManejadorArchivosGenerico.leerArchivo(directorio + "palabras1.txt");
        TArbolTrie triePredecir = new TArbolTrie();
        for (String linea : lineasPredecir){
            triePredecir.insertar(linea);
        }
        
        triePredecir.imprimir();
        System.out.print("\n");

        System.out.println(triePredecir.predecir("ar").toString());
        System.out.println(triePredecir.predecir("po").toString());
        System.out.print("\n");

    }

}