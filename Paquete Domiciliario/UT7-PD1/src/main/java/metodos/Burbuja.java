package metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Burbuja {

    /**
     * Ordenamiento por Búrbuja.
     * @param arregloDatos de tipo int[]
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorBurbuja(int[] arregloDatos) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {

            int N = arregloDatos.length - 1;
            // Recorrida de principio a fin.
            for (int i = 0; i <= N; i++) {
                // Recorrida comparando las claves desde el final hasta i-1;
                for (int j = N; j >= (i + 1); j--) {
                    // Comparación.
                    if (arregloDatos[j] < arregloDatos[j - 1]) {
                        // Realizamos el intercambio de posiciones.
                        Intercambio.intercambia(arregloDatos, j - 1, j);
                    }
                }
            }
            // Retorno del arreglo ordenado.
            return arregloDatos;
        }
        // Si el arregloDatos está vacío o nulo, retorna nulo.
        return null;
    }

}
