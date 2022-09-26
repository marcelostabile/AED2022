package groupid.triesufijos;

import java.util.LinkedList;

/**
 *
 * @author July
 */
public class Main {

    public static void main(String[] args) {
        
        TArbolTrie trie = new TArbolTrie();
        
        trie.insertarSufijos("panamabananas");
        trie.imprimir();
        
        LinkedList <Integer> patron = trie.encontrarPatron("na");
        System.out.println(patron.toString());
        
        //TNodoTrie nodo = new TNodoTrie();
        //LinkedList <String> lista = nodo.ListarSufijos("panamabananas");
        //System.out.println(lista.toString());
    }
}
