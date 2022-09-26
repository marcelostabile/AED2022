import java.util.HashMap;

public class MedicionBuscarHashMap extends Medible{

    private HashMap mapa;

    public MedicionBuscarHashMap(HashMap mapa) {
        this.mapa = new HashMap();
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                mapa.containsKey(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.mapa;
    }
}
