package uy.edu.ucu.aed2;

import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.*;

public class TestCases {

    public TestCases() {}
    
    @Test
    public void insertarSufijoTest() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertarSufijos("1011");
        
        assertEquals(trie.buscar("1"), 1);
        assertEquals(trie.buscar("11"), 1);
        assertEquals(trie.buscar("011"), 1);
        assertEquals(trie.buscar("1011"), 1);
    }
    
    @Test
    public void encontrarPatronTest() {
        TArbolTrie trie = new TArbolTrie();
        trie.insertarSufijos("1001");

        LinkedList <Integer> patron = trie.encontrarPatron("01");
        Object[] vector = patron.toArray();
        
        assertEquals(vector[0], 2);
    }
}
