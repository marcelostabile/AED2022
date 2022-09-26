package metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Quicksort {

    /**
     * Ordenamiento por Quicksort.
     * @param arregloDatos de tipo int[]
     * @param i de tipo int.
     * @param j de tipo int.
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorQuicksort(int[] arregloDatos, int i, int j) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {

            // Determinar el pivote.
            int indicePivote = encontrarPivote(arregloDatos, i, j);
            int pivote = arregloDatos[indicePivote];

            // Ordenar el arreglo.
            int cursorIzq = i;
            int cursorDer = j;

            while (cursorIzq <= cursorDer) {

                // Avanza CursorIzq mientras no llegue al pivote o al otro cursor.
                while (arregloDatos[cursorIzq] < pivote && cursorIzq < j) {
                    cursorIzq++;
                }
                
                // Retrocede CursorDer mientras no llegue al pivote o al otro cursor.
                while (pivote < arregloDatos[cursorDer] && cursorDer > i) {
                    cursorDer--;
                }

                // Los elementos se intercambian según los cursores.
                if (cursorIzq <= cursorDer) {
                    Intercambio.intercambia(arregloDatos, cursorDer, cursorIzq);
                    cursorIzq++;
                    cursorDer--;
                }
                
                // Recursivamente ordenamos subarreglo 1.
                if (i < cursorDer) {
                    ordenarPorQuicksort(arregloDatos, i, cursorIzq-1);
                }
                // Recursivamente ordenamos subarreglo 2.
                if (cursorIzq < j) {
                    ordenarPorQuicksort(arregloDatos, cursorIzq, j);
                }
            }
            // Retorno del arreglo ordenado.
            return arregloDatos;
        }
        // Si el arregloDatos está vacío o nulo, retorna nulo.
        return null;
    }


    /**
     * Método para encontrar el pivote.
     */
    private static int encontrarPivote(int[] arregloDatos, int cursorIzq, int cursorDer) {

        return (cursorDer - cursorIzq) / 2 + cursorIzq;
    }
    
}
