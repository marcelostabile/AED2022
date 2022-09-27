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
    private int ocurrencias;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList();
    }

    public void insertarPagina(int nroPagina) {
        paginas.addLast(nroPagina);
    }
    
    public LinkedList<Integer> getPaginas(){
        return paginas;
    }
    
    public void insertar(String s) {
        // programar el método
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra == true) {
            nodo.ocurrencias++;
        } 
        else {
            nodo.esPalabra = true;
            nodo.ocurrencias = 1;
        }
    }

    public TNodoTrie buscar(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indiceCaracter = s.charAt(c) - 'a';
            if (nodo.hijos[indiceCaracter] == null) {
                return null;
            }
            nodo = nodo.hijos[indiceCaracter];
        }
        if (nodo.esPalabra == true) {
            return nodo;
        } else {
            return null;
        }
    }
     
    public void imprimir() {
        imprimir("", this);
    } 
     
    private void imprimir(String s, TNodoTrie nodo) {
       //programar el método
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    
    public int getOcurrencias() {
        return this.ocurrencias;
    }
}
