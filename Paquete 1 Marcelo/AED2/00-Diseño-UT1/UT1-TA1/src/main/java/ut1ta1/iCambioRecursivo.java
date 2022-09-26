package ut1ta1;

/**
 * Realiza el cambio de monedas.
 * Algoritmo Recursivo.
 * @author mstabile 2022.
 */
public interface iCambioRecursivo {
    
    /**
     * Recibe un "importe" y retorna un arreglo con detalle del cambio.
     * @param importe
     * @param monedas
     * @return un arreglo con las monedas que componene el cambio.
     */
    public int[] cambiarRecursivo(int importe, int[] monedas);
    
}
