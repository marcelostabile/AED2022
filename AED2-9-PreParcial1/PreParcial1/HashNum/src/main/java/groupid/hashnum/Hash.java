package groupid.hashnum;

import java.util.Arrays;

/**
 *
 * @author July
 */
public class Hash {
    
    private int[] tablaHash;
    private double factorDeCarga;    

    public int[] getTablaHash() {
        return tablaHash;
    }

    public double getFactorDeCarga() {
        return factorDeCarga;
    }

    public Hash(int cantClaves) {
        int tamanioTabla = calcularTamanio(cantClaves);
        this.tablaHash = new int[tamanioTabla];
        Arrays.fill(tablaHash, 0);//Todos los elementos de la tabla, tendran valor null
        factorDeCarga = calcFactorCarga(cantClaves, tamanioTabla);
    }    
    
    
    private int calcularTamanio (int cantDeClaves){
        cantDeClaves = (int) (Math.round(cantDeClaves + (cantDeClaves*0.1)));
        if (!esPrimo(cantDeClaves)){
            cantDeClaves = siguientePrimo(cantDeClaves);
        }
        return cantDeClaves;
    }
    
    private double calcFactorCarga(int cantClaves, int tamanioTabla){
        return cantClaves/tamanioTabla;
    }
    
    public int funcionHashing(int unaClave) {
        return (unaClave % (tablaHash.length));
    }
    
    //Encadenamiento Simple
    public int insertar(int unaClave){
        int cantComp = 0;
        int claveHash = funcionHashing(unaClave);
        if (tablaHash[claveHash] == 0){
            tablaHash[claveHash] = unaClave;
            return cantComp + 1;
        }else{
            int contador = 1;
            while (tablaHash[claveHash] != 0){
                claveHash = claveHash + 1;
                contador ++;
                cantComp ++;
                if (claveHash >= tablaHash.length){
                    claveHash = 0;
                }
                if(contador == tablaHash.length){
                    return 0;
                }
            }
            tablaHash[claveHash] = unaClave;            
        }
        return cantComp;
    }
    
    public int buscar(int unaClave){
        int cantComp = 0;
        int claveHash = funcionHashing(unaClave);
        if (tablaHash[claveHash] == unaClave){            
            return 1;
        }else{
            int contador = 1;
            while (tablaHash[claveHash] != unaClave){
                claveHash = claveHash + 1;
                contador ++;
                cantComp ++;
                if (claveHash >= tablaHash.length){
                    claveHash = 0;
                }
                if(contador == tablaHash.length){
                    return 0;
                }
            }                        
        }
        return cantComp;
    }
    
    public static boolean esPrimo(int numero) {
        int cociente = numero - 1;
        while (cociente > 1 && numero % cociente != 0) {
            cociente--;
        }
        return (cociente == 1);
    }
    
    public static int siguientePrimo(int numero) {
        numero++;
        while (!esPrimo(numero)) {
            numero++;
        }
        return numero;
    }
    
}
