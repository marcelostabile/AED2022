package ut1ta1;

/**
 * Realiza el cambio de monedas.
 * Algoritmo Recursivo.
 * @author mstabile 2022.
 */
public class cambioRecursivo {

    /**
     * 
     * @param importe
     * @param monedas
     * @return 
     */
    public static int cambiarRecursivo(int importe, int[] monedas) {

        int minMonedas = importe;
        int actualMonedas = 0;
        // Caso base, el importe se resuelve con una sola moneda, se revisa todo el arreglo de valores de monedas.
        for (int i = 0; i < monedas.length-1; i++) {
            if (monedas[i] == importe) return 1;
        }
        // Se resuelve tomando los valores de las monedas.
        for (int j = 1; j < importe/2; j++) {
            actualMonedas = cambiarRecursivo(j, monedas) + cambiarRecursivo( (importe-j), monedas);
            if (actualMonedas < minMonedas) minMonedas = actualMonedas;
        }
        return minMonedas;
    }
    
}
