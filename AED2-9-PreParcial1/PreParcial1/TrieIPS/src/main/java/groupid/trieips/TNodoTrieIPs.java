package groupid.trieips;

import java.util.LinkedList;

public class TNodoTrieIPs {

    private static final int CANT_CHR = 12;
    private TNodoTrieIPs[] hijos;
    private boolean esPalabra;
    private String nombreDispositivo;

    public TNodoTrieIPs(String Ip, String nombre) {
        hijos = new TNodoTrieIPs[CANT_CHR];
        esPalabra = false;
        nombreDispositivo = nombre;
    }

    public String getNombre(){
        return nombreDispositivo;
    }
    
    public void insertar(String IP, String nombre) {
        TNodoTrieIPs nodo = this;
        for (int c = 0; c < IP.length(); c++) {
            int indice = IP.charAt(c) - '.';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieIPs(IP, nombre );
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }
    
    private void imprimir(String s, TNodoTrieIPs nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + '.'), nodo.hijos[c]);
                }
            }
        }
    }
    
    public void imprimir() {
        imprimir("", this);
    }
    
      private TNodoTrieIPs buscarNodoTrie(String s) {
        TNodoTrieIPs nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - '.';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
     private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieIPs nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                //palabras.add(prefijo + s);
                palabras.add(buscarNodoTrie(prefijo + s).getNombre());
            }
            for (int c = 0; c < CANT_CHR; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s+(char)(c + '.'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
    }
     
    public void predecir(String prefijo, LinkedList<String> palabras) {
       TNodoTrieIPs nodo = buscarNodoTrie(prefijo);
       predecir("", prefijo, palabras, nodo);
    }
    
    public int buscar(String s) {
        TNodoTrieIPs nodo = this;
        int comparaciones=0;
        for (int c = 0; c < s.length(); c++) {
            
            int indice = s.charAt(c) - '.'; //veo el valor ascci de la letra de la cade
            if (nodo.hijos[indice] == null) { // veo si en el nodo esta el valor ascci que quiero comparar
                
                comparaciones=0;
            }
            
            if (nodo.hijos[indice] != null) { // veo si en el nodo esta el valor ascci que quiero comparar
                
                comparaciones=c + 1;
            }
            else{
                return comparaciones=0;
            }
            
            nodo = nodo.hijos[indice]; //avanzo en el hijo
        }
        return comparaciones;
    }
}
