package groupid.hashletras;

/**
 *
 * @author July
 */
public class Main {

    public static void main(String[] args) {
        String[] vectorClaves = ManejadorArchivosGenerico.leerArchivo("./src/main/java/groupid/hashletras/claves.txt");
        
        Hash hash = new Hash(vectorClaves.length);
        
        for (String i:vectorClaves){
            hash.insertar(i);
        }
        
        for (String j:hash.getTablaHash()){
            System.out.println(j);
        }
        
        System.out.println("Comparaciones: " + hash.buscar("int"));
        System.out.println("Fun: " + hash.funcionHashing("int"));
        
    }
}
