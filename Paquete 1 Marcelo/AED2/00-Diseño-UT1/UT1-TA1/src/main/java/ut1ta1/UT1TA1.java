package ut1ta1;

/**
 * MAQUINA DE MONEDAS
 * Algoritmo Ávido.
 * @author mstabile 2022.
 */
public class UT1TA1 {

    public static void main(String[] args) {
        
        // Arreglo con los valores de las monedas disponibles.
        int[] monedas = new int[5];
        monedas[0] = 1;
        monedas[1] = 2;
        monedas[2] = 5;
        monedas[3] = 10;
        monedas[4] = 50;
        
        // Importe a cambiar.
        int importe = 275;
        
        // Ejercicio 1 - Avido
        System.out.println("Ejercicio 1 :" + importe);
        int[] cambioA = ut1ta1.cambioAvido.cambiarAvido(importe, monedas);
        for (int i = 0; i < cambioA.length; i++) {
            System.out.println("Posición " + i + " :" + cambioA[i]);
        }
        
        System.out.println(" ");
        
        // Ejercicio 2 - Recursivo
        System.out.println("Ejercicio 2 :" + importe);
        int cambioR = ut1ta1.cambioRecursivo.cambiarRecursivo(importe, monedas);
        System.out.println("Monedas de cambio: " + cambioR);

    }
}
