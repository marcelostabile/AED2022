package clasificacion1;

/**
 * MergeSort
 * @author mstabile
 */
public class MergeSort {
    
    /**
     * MergeSort
     * @param a
     * @param aux
     * @param izq
     * @param der 
     */
    public void mergeSort(int[] a, int[] aux, int izq, int der) {
        
        if (izq < der) {
            int medio = (izq + der) / 2;
            mergeSort(a, aux, izq, medio);
            mergeSort(a, aux, medio+1, der);
            mezclar(a, aux, izq, medio + 1, izq, der);
        }
    }
    
    
    
}
