package groupid.trieips;

import java.util.LinkedList;

public class TArbolTrieIPs{

    private TNodoTrieIPs raiz;

    public void insertar(String IP, String nombre) {
        if (raiz == null) {
            raiz = new TNodoTrieIPs(null,null);
        }
        raiz.insertar(IP,nombre);
    }
    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        else {
            return 0;
        }
    }
    
    public LinkedList<String> predecir(String prefijo) {
        LinkedList <String> lista = new LinkedList<>();
        if (raiz!=null){
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }
    
    
}
