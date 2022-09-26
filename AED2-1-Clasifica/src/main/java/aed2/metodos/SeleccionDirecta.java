package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class SeleccionDirecta {

    /**
     * Ordenamiento por Selección Directa.
     * Se recibe un arreglo desordenado. Comenzamos con la clave en el indice 0, 
     * recorremos todo el arreglo comparando y determinando si existe una clave menor. 
     * Si hay un valor menor, se intercambia de lugar el elemento según clave. 
     * Continuamos con la clave siguiente, así sucesivamente hasta comparar todo el arreglo.
     * @param arregloDatos de tipo int[]
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorSeleccion(int[] arregloDatos) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {
            
            for (int i = 0; i < arregloDatos.length - 1; i++) {
                int indiceMenor = i;
                int claveMenor = arregloDatos[i];
                for (int j = i + 1; j < arregloDatos.length; j++) {
                    if (arregloDatos[j] < claveMenor) {
                        indiceMenor = j;
                        claveMenor = arregloDatos[j];
                    }
                }
                // Si el indiceMenor cambió y ahora es un j.
                // Intercambiamos el elemento en i con el elemento en el indiceMenor.
                if (indiceMenor != i) {
                    Intercambio.intercambia(arregloDatos, i, indiceMenor);
                }
            }
            // Retorno del arreglo ordenado.
            return arregloDatos;
        }
        // Si el arregloDatos está vacío o nulo, retorna nulo.
        return null;
    }

}
