package ut1ta1;

/**
 * Cambio Dinamico
 * @author mstabile
 */
public class cambioDinamico {
    
    public int[] cambiarDinamico (int importeTotal, int[] monedas) {
        
        int cantMonDiferentes = monedas.length;
        int[] salida = new int[cantMonDiferentes];
        
        int[] cantMonUsadas = new int[importeTotal+1];
        int[] ultimaMonUsada = new int[importeTotal+1];
        int[] indiceUltMonUsada = new int[importeTotal+1];
        
        int minimasMonedas;
        int nuevaMoneda;
        int indiceNuevaMoneda;
                
        cantMonUsadas[0] = 0;
        ultimaMonUsada[0] = 0;
        indiceUltMonUsada[0] = 0;
        
        for (int importeActual = 1; importeActual <= importeTotal; importeActual++){
            minimasMonedas = importeActual; nuevaMoneda = 1; indiceNuevaMoneda = 0;
            for (int i=1; i < cantMonDiferentes;i++){
                if (monedas[i] <= importeActual){
                    if (cantMonUsadas[importeActual - monedas[i]]+1 < minimasMonedas){
                        minimasMonedas = cantMonUsadas[importeActual - monedas[i]]+1;
                        nuevaMoneda = monedas[i];
                        indiceNuevaMoneda = i;
                    }
                }
            }
            cantMonUsadas[importeActual] = minimasMonedas;
            ultimaMonUsada[importeActual] = nuevaMoneda;
            indiceUltMonUsada[importeActual] = indiceNuevaMoneda;
        }
        
        int k = importeTotal;
            while (k > 0){
                salida[indiceUltMonUsada[k]]++;
                k = k - ultimaMonUsada[k];
            }
        return salida;
    }
    
}
