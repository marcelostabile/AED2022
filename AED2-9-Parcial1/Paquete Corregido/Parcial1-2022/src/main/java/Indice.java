import java.util.LinkedList;

public class Indice {

    /**
     * FILTRAR ´PALABRA
     * @param args the command line arguments
     */
    public static String filtrarPalabra(String unaPalabra) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter = unaPalabra.charAt(i);
            if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')) {
                sb.append(caracter);
            }
        }
        return sb.toString().toLowerCase();
    }
    
    
    /**
     * MAIN
     * @param args 
     */
    public static void main(String[] args) {

        // LINEAS POR PAGINA
        int lineasPorPagina = 50;

        // TRIE INDICE
        TArbolTrie trieIndice = new TArbolTrie();
        
        // INSERTAR PALABRAS EN EL INDICE
        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\palabrasdelindice.txt");
        
        for (String unaPalabra : palabras){
            trieIndice.insertar(filtrarPalabra(unaPalabra));
        }
        
        // LEER LIBRO Y OBTENER LAS PALABRAS DE CADA LINEA.
        String[] libro = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\librotexto.txt");
        
        for (int lineaNro = 0; lineaNro <= libro.length-1; lineaNro++) {
            // Procesmos la linea.
            String lineaStr = libro[lineaNro].toString();
            String[] lineaArr = lineaStr.split(" ");
            // Obtenemos nro de página.
            int paginaNro = lineaNro/50;
            
            // PARA CADA PALABRA, LA BUSCO EN EL INDICE E INSERTO NRO PAGINA
            for (String palabra : lineaArr) {
                TNodoTrie miNodo = trieIndice.buscar(filtrarPalabra(palabra));
                if (miNodo != null) {
                    miNodo.insertarPagina(paginaNro);
                }
            }
        }
        
        // IMPRIMIR INDICE CON PALABRA, OCURRENCIAS, PAGINAS.
        trieIndice.imprimir();
    }

}
