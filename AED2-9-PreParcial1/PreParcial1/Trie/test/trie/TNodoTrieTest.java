package trie;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author July
 */
public class TNodoTrieTest {
    
    public TNodoTrieTest() {
    }
    
    @Test
    public void testInsertar() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("casa");
        
        int ocurrencias = trie.buscar("casa");
        assertEquals(ocurrencias, 2);
    }
    
    @Test
    public void testInsertarPaginas() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertarPaginas("programacion, 15, 18, 27");
        
        LinkedList <Integer> pag = trie.getRaiz().buscarNodo("programacion").getPaginas();
        Object[] vector = pag.toArray();
        
        assertEquals(vector[0], 15);
        assertEquals(vector[1], 18);
        assertEquals(vector[2], 27);
    }

    /*@Test
    public void testBuscarNodo() {
        TArbolTrie trie = new TArbolTrie();
        int CANT_CHR_ABECEDARIO = 26;
        trie.insertar("casa");
        trie.insertar("casamiento");
        char letra = ' ';
        
        TNodoTrie nodo = trie.getRaiz().buscarNodo("cas");
        
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.getHijos()[c] != null) {
                    letra = (char) (nodo.getHijos()[c]-'a');
                }
            }
        assertEquals(letra , 's');
    }*/
    
    @Test
    public void testPredecir() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("perro");
        trie.insertar("pera");
        trie.insertar("persona");
        trie.insertar("pensar");
        trie.insertar("paz");
        trie.insertar("arbol");
        trie.insertar("gato");

        LinkedList <String> result = trie.predecir("pe");
        Object[] vector = result.toArray();
        
        assertEquals(vector[0], "pensar");
        assertEquals(vector[1], "pera");
        assertEquals(vector[2], "perro");
        assertEquals(vector[3], "persona");
    }
    
    @Test
    public void testBuscarExitosa (){
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("arbol");
        trie.insertar("grito");
        trie.insertar("casa");

        assertEquals(trie.buscar("casa"), 2);
        assertEquals(trie.buscar("casamiento"), 1);
    }

    @Test
    public void TestBusacarNoExitosa (){
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("casa");
        trie.insertar("casamiento");
        trie.insertar("arbol");
        trie.insertar("grito");

        assertEquals(trie.buscar("artera"), 0);
        assertEquals(trie.buscar("perro"), 0);
    }
}
