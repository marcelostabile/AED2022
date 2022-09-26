package groupid.collections;

/**
 *
 * @author Usuario
 */
public class MedicionBuscarTrie extends Medible {
    
    private TArbolTrie arbolTrie;

    public MedicionBuscarTrie(TArbolTrie arbolTrie) {
        this.arbolTrie = arbolTrie;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                arbolTrie.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arbolTrie;
    }
    
}
