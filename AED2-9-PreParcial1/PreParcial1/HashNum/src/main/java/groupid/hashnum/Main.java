package groupid.hashnum;

/**
 *
 * @author July
 */
public class Main {

    public static void main(String[] args) {
        
        String[] vectorClaves = ManejadorArchivosGenerico.leerArchivo("./src/main/java/groupid/hashnum/claves.txt");
        
        Hash hash = new Hash(vectorClaves.length);
        
        for (String i:vectorClaves){
            hash.insertar(Integer.parseInt(i));
        }
        
        for (int j:hash.getTablaHash()){
            System.out.println(j);
        }
        
        System.out.println("Comparaciones: " + hash.buscar(15));
        System.out.println("Fun: " + hash.funcionHashing(15));
    }
}
