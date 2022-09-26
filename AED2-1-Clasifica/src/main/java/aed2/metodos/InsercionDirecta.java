package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class InsercionDirecta {

    /**
     * Ordenamiento por inserción directa.
     * @param arregloDatos de tipo int[]
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorInsercion(int[] arregloDatos) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {
        
            for (int i = 1; i < arregloDatos.length; i++) {
                int aux = arregloDatos[i];
                int anterior = i - 1;
                while (anterior >= 0 && aux < arregloDatos[anterior]) {
                    arregloDatos[anterior + 1] = arregloDatos[anterior];
                    anterior = anterior - 1;
                }
                arregloDatos[anterior + 1] = aux;
            }
            // Retorno del arreglo ordenado.
            return arregloDatos;
        }
        // Si el arregloDatos está vacío o nulo, retorna nulo.
        return null;
    }

}
