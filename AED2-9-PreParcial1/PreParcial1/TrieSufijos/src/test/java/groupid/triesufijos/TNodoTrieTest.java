package groupid.triesufijos;

import java.util.LinkedList;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author July
 */
public class TNodoTrieTest {
    
    public TNodoTrieTest() {
    }

    /**
     * Test of ListarSufijos method, of class TNodoTrie.
     */
    @org.junit.Test
    public void testListarSufijos() {
        TNodoTrie nodo = new TNodoTrie();
        LinkedList <String> result = nodo.ListarSufijos("hola");
        Object[] vector = result.toArray();
        
        assertEquals(vector[0], "a");
        assertEquals(vector[1], "la");
        assertEquals(vector[2], "ola");
        assertEquals(vector[3], "hola");
    }

    /**
     * Test of insertarSufijos method, of class TNodoTrie.
     */
    @org.junit.Test
    public void testInsertarSufijos() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertarSufijos("hola");
        
        assertEquals(trie.buscar("a"), 1);
        assertEquals(trie.buscar("hola"), 1);
        assertEquals(trie.buscar("la"), 1);
        assertEquals(trie.buscar("ola"), 1);
    }
    
    @org.junit.Test
    public void testEncontrarPatron() {
        TArbolTrie trie = new TArbolTrie();
        
        trie.insertarSufijos("panamabananas");
        LinkedList <Integer> patron = trie.encontrarPatron("na");
        Object[] vector = patron.toArray();
        
        assertEquals(vector[0], 2);
        assertEquals(vector[1], 8);
        assertEquals(vector[2], 10);
    }
    
}
