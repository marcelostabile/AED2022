package aed2.clasificador;

import java.util.Random;

public class GeneradorDatosGenericos {
	
    //private static int TAMANIO_MAX = 32000;

    /**
     * generarDatosAleatorios
     * @param TAMANIO_MAX
     * @return 
     */
    public int[] generarDatosAleatorios(int TAMANIO_MAX) {
        
        Random rnd = new Random();
        int[] datosGenerados = new int[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            
            while(datosUtilizados[j]){
                j = (j + 1) % TAMANIO_MAX;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    /**
     * generarDatosAscendentes
     * @param TAMANIO_MAX
     * @return 
     */
    public int[] generarDatosAscendentes(int TAMANIO_MAX) {
        int [] copiaAscendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    /**
     * generarDatosDescendentes
     * @ret 
     * @param TAMANIO_MAXurn 
     */
    public int[] generarDatosDescendentes(int TAMANIO_MAX) {
        int [] copiaDescendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaDescendente[i] = TAMANIO_MAX - i;
        }
        return copiaDescendente;
    }

}
