package groupid.trieips;
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        
        TArbolTrieIPs trie = new TArbolTrieIPs();

        String[] palabras = ManejadorArchivosGenerico.leerArchivo ("./src/main/java/groupid/trieips/PalabrasIPs.txt");
        
        for (String p : palabras) {
            String [] nodoIP = p.split(",");
            trie.insertar(nodoIP[0], nodoIP[1]);
        }
        //trie.insertar("010.024.007.0024","Dispositivo 1");
        //trie.insertar("100.251.008.0039","Dispositivo 8");
        trie.imprimir();
        
    }
}