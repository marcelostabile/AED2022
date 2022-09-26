package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie{

    private TNodoTrie raiz;

    public TNodoTrie getRaiz() {
        return raiz;
    }
    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        else {
            return 0;
        }
    }
    
    public void insertarSufijos (String cadena){
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarSufijos(cadena);
    }
    
    @Override
    public LinkedList<Integer> encontrarPatron(String patron) {
        LinkedList<Integer> posiciones = new LinkedList<>();
        if (raiz != null) {
            raiz.encontrarPatron(patron,posiciones);
        }
        return posiciones;
    }
    
    
    
}
