package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Heapsort {
    
    /**
     * Ordenamiento por heapsort.
     * @param arregloDatos de tipo int[]
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorHeapSort(int[] arregloDatos) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {
            
            int N = arregloDatos.length;
            for (int i = (N-1) / 2; i >= 0; i--) {
                desplazaElemento(arregloDatos, i, N-1);
            }
            for (int i = N-1; i > 0; i--) {
                Intercambio.intercambia(arregloDatos, 0, i);
                desplazaElemento(arregloDatos, 0, i-1);
            }
            // Retorno del arreglo ordenado.
            return arregloDatos;
        }
        // Si el arregloDatos está vacío o nulo, retorna nulo.
        return null;
    }    


    /**
     * Desplaza los elementos.
     * @param arregloDatos
     * @param primero
     * @param ultimo
     */
    private static void desplazaElemento(int[] arregloDatos, int primero, int ultimo) {

        if (primero < ultimo) {
            int actual = primero;
            while (actual <= (ultimo / 2) ) {
                if (ultimo == actual * 2) {
                    if (arregloDatos[actual] > arregloDatos[actual * 2]) {
                        Intercambio.intercambia(arregloDatos, actual, actual * 2);
                    }
                    actual = ultimo;
                } else {
                    int menor = Math.min(actual * 2, actual * 2 + 1);
                    if (arregloDatos[actual] > arregloDatos[menor]) {
                        Intercambio.intercambia(arregloDatos, actual, menor);
                        actual = menor;
                    } else {
                        actual = ultimo;
                    }
                }
            }
        }
    }

    /**
     * Imprime por pantalla el contenido de una arregloDatos.
     * @param arregloDatos
     */
    public static void imprimirLista(int[] arregloDatos) {

        System.out.println("Imprimiendo arregloDatos:");
        for (int i = 0; i <= arregloDatos.length-1; i++) {
            System.out.println("[" + i + "]: " + arregloDatos[i]);
        }
    }

}
