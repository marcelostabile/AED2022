package groupid.clasif1;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    public boolean estaOrdenado(int[] vector) {
        for (int i = 0; i < vector.length-1; i++) {
            if (vector[i] > vector[i+1]) {
                return false;
            }
        }
        return true;
    }

    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int inc : incrementos) {
            for (int i = inc; i < datosParaClasificar.length; i++) {
                j = i - inc;
                while (j >= 0 && datosParaClasificar[j + inc] < datosParaClasificar[j]) {
                    intercambiar(datosParaClasificar, j, j + inc);
                    j -= inc;
                }
            }
        }
        return datosParaClasificar;
    }
    
    private int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j+1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    private int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        int [] contador = {0};
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1, contador);
	System.out.println ("Profundidad de la llamada recursiva: " + contador[0]);
	return datosParaClasificar;
    }
    
    private void quicksort (int[] entrada, int i, int j, int [] contador) {
        int izquierda = i;
	int derecha = j;
        int [] contadorDerecha={0};
        int [] contadorIzquierda={0};

	int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
	if (posicionPivote >= 0){
            int pivote = entrada[posicionPivote];// aca necesita el valor no la posicion  
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++; // estaba izquierda --
                }
                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--; // estaba derecha ++
                }
                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }
            contador[0]++;
            if (i < derecha)
                quicksort(entrada, i, derecha, contador); //Deberia ir la derecha
            contadorDerecha[0]++;
            if (contadorDerecha[0]>contador[0]){
                contador[0]=contadorDerecha[0];
            }
            if (izquierda < j)
                quicksort(entrada, izquierda, j, contador); // Deberia ir a la izquierda
            contadorIzquierda[0]++;
            if (contadorIzquierda[0]>contador[0]){
                contador[0]=contadorIzquierda[0];
            }
        }
    }
    
    //Si el largo es mayor a 1 devuelvo el valor del mayor de los dos primeros
    //Si es 1, devuelvo ese valor
    //Si no -1
    public int encuentraPivote (int i, int j, int[] entrada){
        if (entrada.length > 1){
            if(entrada[0] > entrada[1]){
                return entrada[0];
                }else{
                return entrada[1];
                }
            }else{
            if (entrada.length == 1){
                return entrada[0];
            }
        }
        return -1;
    }

}
