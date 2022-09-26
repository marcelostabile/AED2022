package groupid.triesufijos;

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
        
    public void insertarSufijos (String cadena){
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarSufijos(cadena);
    }
    
    public LinkedList<Integer> encontrarPatron(String patron) {
        LinkedList<Integer> posiciones = new LinkedList<>();
        if (raiz != null) {
            raiz.encontrarPatron(patron,posiciones);
        }
        return posiciones;
    }
    

}

    
