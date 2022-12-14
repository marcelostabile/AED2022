package trie;

import java.util.LinkedList;

public class TArbolTrie {

    private TNodoTrie raiz;

    public TNodoTrie getRaiz() {
        return raiz;
    }

    /*
    * Insertar una palabra en el trie.
    */
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    /**
     * Imprime todas las palabras del trie.
     */
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    /**
     * Buscar una palabra en el trie.
     * @param palabra
     * @return cantidad de letras encontradas.
     */
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        // Si la raiz no existe, retorna cero.
        return 0;
    }
    
    public void insertarPaginas(String linea) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarPaginas(linea);
    }
    
    public void imprimirPaginas() {
        if (raiz != null) {
            raiz.imprimirPaginas();
        }
    }
    
    public LinkedList <String> predecir (String unPrefijo){
        LinkedList <String> lista = new LinkedList<>();
        if (raiz != null){
            raiz.predecir (unPrefijo, lista);
        }
        return lista;
    }
    
    public LinkedList <String> predecirCatedra (String unPrefijo){
        LinkedList <String> lista = new LinkedList<>();
        if (raiz != null){
            raiz.predecirCatedra ("",unPrefijo, lista);
        }
        return lista;
    }
}

    
