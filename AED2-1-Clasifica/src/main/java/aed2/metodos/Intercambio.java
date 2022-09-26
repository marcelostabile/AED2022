package aed2.metodos;
/**
 * @author Marcelo Stabile 2022.
 */
public class Intercambio {

    /**
     * Recibe un arreglo y los indices (1 y 2) para el cambio de lugar de los 2 elementos.
     * @param arregloDatos de tipo int[]
     * @param indice1 de tipo int.
     * @param indice2 de tipo int.
     */
    public static void intercambia(int[] arregloDatos, int indice1, int indice2) {

        // clave del elemento 2.
        int aux = arregloDatos[indice2];
        
        // reasignamos el elemento 1 a la posición del elemento 2.
        arregloDatos[indice2] = arregloDatos[indice1];
        
        // reasignamos el elemento 2.
        arregloDatos[indice1] = aux;
    }

}
