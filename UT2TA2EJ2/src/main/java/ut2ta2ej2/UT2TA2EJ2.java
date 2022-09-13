package ut2ta2ej2;

public class UT2TA2EJ2 {

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
        trie.imprimir();
        System.out.println(trie.buscar("casamiento"));
    }
}