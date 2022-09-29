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
        ocurrencias = 0;
    }

    public void insertarPagina(int paginaNro) {
        // Agrego una ocurrencia. 
        ocurrencias++;
        // Agrego el nro de página si no existe previamente.
        if (!paginas.contains(paginaNro)) {
            paginas.addLast(paginaNro);
        }
    }
    
    public LinkedList<Integer> getPaginas(){
        return paginas;
    }
    
    public void insertar(String s) {
        
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
        } else {
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
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + " - Ocurrencias: " + nodo.getOcurrencias() + " - Pagínas: " + nodo.getPaginas().toString());
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
    
    public String[] listar() {
        
        // Lista de datos.
        LinkedList<String> listaDatos = new LinkedList<>();
        listar("", this, listaDatos);
        // Convertir LinkedList to Arreglo
        String[] arregloDatos = new String[listaDatos.size()];
        return listaDatos.toArray(arregloDatos);
    }
    
    private void listar(String s, TNodoTrie nodo, LinkedList<String> listaDatos) {

        if (nodo != null) {
            if (nodo.esPalabra) {
                String palabra = (s + " - Ocurrencias: " + nodo.getOcurrencias() + " - Paginas: " + nodo.getPaginas().toString());
                listaDatos.add(palabra);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    listar(s + (char) (c + 'a'), nodo.hijos[c], listaDatos);
                }
            }
        }
    }

}
