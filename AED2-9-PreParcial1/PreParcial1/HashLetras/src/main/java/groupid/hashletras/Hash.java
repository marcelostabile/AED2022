package groupid.hashletras;

import java.util.Arrays;

public class Hash {
    
    private String[] tablaHash;
    private double factorDeCarga;
    

    public String[] getTablaHash() {
        return tablaHash;
    }

    public double getFactorDeCarga() {
        return factorDeCarga;
    }

    public Hash(int cantClaves) {
        int tamanioTabla = calcularTamanio(cantClaves);
        tablaHash = new String[tamanioTabla];
        Arrays.fill(tablaHash, null);//Todos los elementos de la tabla, tendran valor null
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
    
    public int funcionHashing (String unaClave){
        int claveAEntero = 0;
        for (int i = 0; i < unaClave.length(); i++) {
            claveAEntero = claveAEntero + (unaClave.charAt(i)-'a');            
        }
        return claveAEntero%tablaHash.length;        
    }
    
    //Encadenamiento Simple
    public int insertar(String unaClave){
        int cantComp = 0;
        int claveHash = funcionHashing(unaClave);
        if (tablaHash[claveHash] == null){
            tablaHash[claveHash] = unaClave;
            return cantComp + 1;
        }else{
            int contador = 1;
            while (tablaHash[claveHash] != null){
                claveHash = claveHash + 1;
                contador ++;
                cantComp ++;
                if (claveHash >= tablaHash.length){
                    claveHash = 0;
                }
                if(contador == tablaHash.length){
                    return 1;
                }
            }
            tablaHash[claveHash] = unaClave;            
        }
        return cantComp;
    }
    
    public int buscar(String unaClave){
        int cantComp = 0;
        int claveHash = funcionHashing(unaClave);
        if (tablaHash[claveHash] == null){            
            return 1;
        }else{
            int contador = 1;
            while (tablaHash[claveHash] != null){
                contador ++;
                cantComp ++;
                if(tablaHash[claveHash].compareTo(unaClave) == 0){
                    return cantComp;
                }
                claveHash = claveHash + 1;

                if (claveHash >= tablaHash.length){
                    claveHash = 0;
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
