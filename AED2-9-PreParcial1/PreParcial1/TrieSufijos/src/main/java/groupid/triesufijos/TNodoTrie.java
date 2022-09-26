package groupid.triesufijos;

import java.util.LinkedList;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int ocurrencias;
    private LinkedList<Integer> paginas = new LinkedList<>();
    private int posicion;

    public TNodoTrie[] getHijos() {
        return hijos;
    }

    public LinkedList<Integer> getPaginas() {
        return paginas;
    }

    // Constructor.
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        posicion = -1;
    }

    /**
     * Insertar una palabra.
     * @param unaPalabra 
     */
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
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

    /**
     * Imprimir la palabra.
     * @param s
     * @param nodo 
     */
    private void imprimir(String s, TNodoTrie nodo) {
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

    public void imprimir() {
        imprimir("", this);
    }
    
    /**
     * Buscar una palabra.
     * @param unaPalabra
     * @return cantidad de letras encontradas.
     */
    public int buscar(String unaPalabra) {
        // nodoActual.
        TNodoTrie nodo = this;
        // recorremos la palabra.
        for (int c = 0; c < unaPalabra.length(); c++) {
            // indice del caracter buscado.
            int indiceCaracter = unaPalabra.charAt(c) - 'a';
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
        
    public TNodoTrie buscarNodo (String prefijo){
        TNodoTrie nodo = this;
        for (int c = 0; c < prefijo.length(); c++) {
            // indice del caracter buscado.
            int indiceCaracter = prefijo.charAt(c) - 'a';
            // si no existe el siguiente caracter, salimos retornando cero.
            if (nodo.hijos[indiceCaracter] == null) {
                return null;
            }
            // Existe la siguiente letra, asignamos el hijo como nodo actual.
            nodo = nodo.hijos[indiceCaracter];
        }
        return nodo;
    }
    
    //Los sufijos los lista recorriendo la cadena desde atrás hacia adelante
    //Pero no están en el orden en que se insertan en el trie
    public LinkedList <String> ListarSufijos (String cadena) {
        LinkedList <String> lista = new LinkedList<>();
        String sufijo = "";
        for (int i = (cadena.length()-1); i >= 0; i--){
            sufijo = cadena.charAt(i) + sufijo;
            lista.add(sufijo);
        }
        return lista;
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
            int indice = unaPalabra.charAt(c) - 'a';
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
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (hijos[c] != null) {
                hijos[c].obtenerPosiciones(posiciones);
            }
        }
    }
    
    
}
