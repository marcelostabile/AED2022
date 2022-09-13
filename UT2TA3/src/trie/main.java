package trie;

public class main {

    public static void main(String[] args) {
// Crear una instancia de un arbol Trie.
// Leer un archivo palabras.txt
// Para cada palabra encontrada, insertarla en el Trie
// Por último, imprimir el trie.
// Ejemplo de uso del Trie.
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        //trie.insertar("caño");
        trie.insertar("arbol");
        trie.insertar("grito");
        
        trie.insertar("casa");
        trie.insertar("casamiento");
        //trie.insertar("caño");
        trie.insertar("arbol");
        trie.insertar("grito");
        trie.insertar("arbol");
        trie.insertar("grito");
        trie.insertar("grito");
        
        trie.imprimir();
        
        System.out.println("Ocurrencias de 'arbol': " + trie.buscar("arbol"));
        System.out.println("Ocurrencias de 'casa': " + trie.buscar("casa"));
        System.out.println("Ocurrencias de 'casamiento': " + trie.buscar("casamiento"));
        System.out.println("Ocurrencias de 'grito': " + trie.buscar("grito"));
        
        /****************/
        /* TRIE ARCHIVO */
        /****************/
        String[] lineasArchivo = ManejadorArchivosGenerico.leerArchivo("src\\trie\\palabras1.txt");
        TArbolTrie trieArchivo = new TArbolTrie();
        for (String i:lineasArchivo){
            trieArchivo.insertar(i);
        }
        //trieArchivo.imprimir();
        
        /****************/
        /* TRIE PAGINAS */
        /****************/
        System.out.print("\n");
        String[] lineasArchivo2 = ManejadorArchivosGenerico.leerArchivo("src\\trie\\palabras_paginas.txt");
        TArbolTrie trieArchivo2 = new TArbolTrie();
        for (String i:lineasArchivo2){
            trieArchivo2.insertarPaginas(i);
        }
        trieArchivo2.imprimirPaginas();
    }
}