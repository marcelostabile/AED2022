package ut2ta2ej2;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int ocurrencias;

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
    
    // COMPLETAR EL MÉTODO DE BUSCAR, COMO INDICA LA LETRA DEL EJERCICIO.
    
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
}
