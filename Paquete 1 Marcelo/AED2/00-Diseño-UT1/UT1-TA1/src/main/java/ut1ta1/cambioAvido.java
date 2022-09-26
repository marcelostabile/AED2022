package ut1ta1;

/**
 * Realiza el cambio de monedas.
 * Algoritmo Ávido.
 * @author mstabile 2022.
 */
public class cambioAvido {
    
    /**
     * Recibe un "importe" y retorna un arreglo con detalle del cambio.
     * @param importe
     * @param monedas
     * @return un arreglo con las monedas que componene el cambio.
     */
    public static int[] cambiarAvido(int importe, int[] monedas) {
        
        // Arreglo de enteros, longitud igual a "monedas".
        int[] salida = new int[monedas.length];
        
        // Recorremos el arreglo de monedas hasta terminar. //**Función Solución-Prometedor**
        for (int i = monedas.length-1; i > 0; i--) {
            while (monedas[i] <= importe) {                 //**Función selección**
                salida[i]++;
                importe = importe - monedas[i]; 
            }
        }
        return salida;
    }
    
    /**
     * int[] monedas: conjunto candidato.
     * int[] salida: conjunto solución.
     */
    
}
