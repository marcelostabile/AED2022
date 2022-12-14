package trie;

import java.util.LinkedList;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int ocurrencias;
    private LinkedList<Integer> paginas = new LinkedList<>();

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
    
    public void insertarPaginas(String linea) {
        TNodoTrie nodo = this;

        String [] info_pag = linea.split(",");
        String palabra = info_pag[0];
        LinkedList<Integer> lista_pag = new LinkedList<>(); 
        
        //Armo la lista paginas
        for (Integer i = 1 ; i< info_pag.length; i++){
            lista_pag.add(Integer.parseInt(info_pag[i].trim()));
        }
                
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra == true) {
            for (Integer j: lista_pag)
            nodo.paginas.add(j);
        } 
        else {
            nodo.esPalabra = true;
            for (Integer j: lista_pag)
            nodo.paginas.add(j);
        }
    }
    
    private void imprimirPaginas(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s + nodo.paginas.toString());
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirPaginas(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    public void imprimirPaginas() {
        imprimirPaginas("", this);
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
        
    public void predecirCatedra (String s, String prefijo, LinkedList<String> palabras){
        TNodoTrie nodo = buscarNodo(prefijo);
        predecirHijosCatedra(s, prefijo, palabras, nodo);
    }
    
    private void predecirHijosCatedra (String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo+s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecirHijosCatedra(s + (char)(c + 'a'), prefijo, palabras ,nodo.hijos[c]);
                }
            }
        }
    }
    
    private LinkedList<String> predecirHijos (TNodoTrie nodo, String prefijo, LinkedList<String> lista){
        if (nodo != null) {
            if (nodo.esPalabra) {
                lista.add(prefijo);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecirHijos(nodo.hijos[c], prefijo + (char) (c + 'a'), lista);
                }
            }
        }
        return lista;
    }
    
    public LinkedList<String> predecir (String prefijo, LinkedList<String> lista){
        TNodoTrie nodo = buscarNodo(prefijo);
        return predecirHijos(nodo, prefijo, lista);
    }
    

    
}
