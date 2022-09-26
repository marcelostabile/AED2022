package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Quicksort {

    /**
     * Ordenamiento por Quicksort.
     * @param arregloDatos de tipo int[]
     * @param izq de tipo int.
     * @param der de tipo int.
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorQuicksort(int[] arregloDatos, int i, int j) {
        
        int pivote = arregloDatos[i];
        int cursorIzq = i;
        int cursorDer = j;

        while (cursorIzq < cursorDer) {
            while (arregloDatos[cursorIzq] <= pivote && cursorIzq < cursorDer) {
                cursorIzq++;
            }
            while (arregloDatos[cursorDer] > pivote) {
                cursorDer--;
            }
            if (cursorIzq < cursorDer) {
                intercambiar(arregloDatos, cursorIzq, cursorDer);
            }
        }

        arregloDatos[i] = arregloDatos[cursorDer];
        arregloDatos[cursorDer] = pivote;

        if (i < (cursorDer - 1)) {
            ordenarPorQuicksort(arregloDatos, i, cursorDer - 1);
        }
        if (cursorDer + 1 < j) {
            ordenarPorQuicksort(arregloDatos, cursorDer + 1, j);
        }
        return arregloDatos;
    }

    private static void intercambiar(int[] lista, int a, int b) {
        int aux = lista[a];
        lista[a] = lista[b];
        lista[b] = aux;
    }

}