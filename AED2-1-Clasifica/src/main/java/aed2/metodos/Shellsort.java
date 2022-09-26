package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Shellsort {
    
    /**
     * Ordenamiento por Shellsort.
     * @param arregloDatos de tipo int[]
     * @return arreglo ordenado o nulo si la entrada está vacía.
     */
    public static int[] ordenarPorShell(int[] arregloDatos) {

        // Si el arregloDatos está vacío o nulo, retorna nulo.
        if (arregloDatos != null | arregloDatos.length==0 ) {

            int j = 0;
            int incre = 0;
            int[] incrementos = new int[]{103, 73, 43, 23, 13, 3, 1};

            for (int incremento = 0; incremento < incrementos.length; incremento++) {
                
                // Tomo valor del incremento.
                incre = incrementos[incremento];
                
                // Recorrido
                if (incre < (arregloDatos.length / 2)) {
                    for (int i = incre; i < arregloDatos.length; i++) {
                        j = i - incre;
                        
                        // Si cumple, realizamos el intercambio.
                        while ( (j >= 0) && (arregloDatos[j + incre] < arregloDatos[j]) ) {
                            Intercambio.intercambia(arregloDatos, j, j + incre);
                            j = j - incre;
                        }
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
