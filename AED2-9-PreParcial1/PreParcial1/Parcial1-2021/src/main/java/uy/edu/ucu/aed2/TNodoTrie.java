package uy.edu.ucu.aed2;

import java.util.LinkedList;

public class TNodoTrie {

    private static final int CANT_CHR = 2;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int posicion;
    private int ocurrencias;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR];
        esPalabra = false;
        posicion = -1;
    }
    
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + '0'), nodo.hijos[c]);
                }
            }
        }
    }
    
    public void imprimir() {
        imprimir("", this);
    }
    
    public int buscar(String unaPalabra) {
        // nodoActual.
        TNodoTrie nodo = this;
        // recorremos la palabra.
        for (int c = 0; c < unaPalabra.length(); c++) {
            // indice del caracter buscado.
            int indiceCaracter = unaPalabra.charAt(c) - '0';
            // si no existe el siguiente caracter, salimos retornando cero.
            if (nodo.hijos[indiceCaracter] == null) {
                return 0;
            }
            // Existe la siguiente letra, asignamos el hijo como nodo actual.
            nodo = nodo.hijos[indiceCaracter];
        }
        if (nodo.esPalabra == true) {
            return nodo.ocurrencias;
        } else {
            return 0;
        }
    }
    
    private TNodoTrie buscarNodo(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    public void insertarSufijos (String cadena) {
        String sufijo = "";
        for (int i = (cadena.length()-1); i >= 0; i--){
            sufijo = cadena.charAt(i) + sufijo;
            insertarSufijo(sufijo, i);
        }
    }
    
    public void insertarSufijo(String unaPalabra, int pos) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra == true) {
            nodo.posicion = pos;
            nodo.ocurrencias++;
        } 
        else {
            nodo.esPalabra = true;
            nodo.posicion = pos;
            nodo.ocurrencias = 1;
        }
    }
    
    public void encontrarPatron(String patron, LinkedList<Integer> posiciones) {
        TNodoTrie nodo = buscarNodo(patron);
        if (nodo != null) {
            nodo.obtenerPosiciones(posiciones);
        }
    }
    
    public void obtenerPosiciones(LinkedList<Integer> posiciones){
        if (posicion >= 0) {
            posiciones.add(posicion);
        }
        for (int c = 0; c < CANT_CHR; c++) {
            if (hijos[c] != null) {
                hijos[c].obtenerPosiciones(posiciones);
            }
        }
    }
}
