/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

import java.util.LinkedList;

public class TNodoTrie {
    
    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList();
    }

    public LinkedList<Integer> getPaginas(){
        return paginas;
    }
    
    public void insertar(String s) {
        // programar el método
    }

    public TNodoTrie buscar(String s) {
        //programar el método
        return null;
    }
     
    public void imprimir() {
        imprimir("", this);
    } 
     
    private void imprimir(String s, TNodoTrie nodo) {
       //programar el método
    }
   
   
}
