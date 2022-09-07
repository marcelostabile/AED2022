package clasificador;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void obtenerMedidas(int tamanioVector, int tamanioConjuntoPromedio) {
        
        TMedidorTiempo medidor = new TMedidorTiempo();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        
        List<int[]> conjuntoParaPromediarAsc = new LinkedList<>();
        List<int[]> conjuntoParaPromediarDes = new LinkedList<>();
        List<int[]> conjuntoParaPromediarAle = new LinkedList<>();

        int[] vectorAscendente = gdg.generarDatosAscendentes(tamanioVector);
        int[] vectorDescendente = gdg.generarDatosDescendentes(tamanioVector);
        int[] vectorAleatorio = gdg.generarDatosAleatorios(tamanioVector);

        for (int i = 0; i < tamanioConjuntoPromedio; i++) {
            conjuntoParaPromediarAsc.add(gdg.generarDatosAscendentes(tamanioVector));
            conjuntoParaPromediarDes.add(gdg.generarDatosDescendentes(tamanioVector));
            conjuntoParaPromediarAle.add(gdg.generarDatosAleatorios(tamanioVector));
        }
        
        System.out.println("");
        System.out.println("+--------------------+");
        System.out.println("| OBTENIENDO MEDIDAS |");
        System.out.println("+--------------------+");
        System.out.println(" Tamaño entrada: " + tamanioVector);
        for (int metodoSeleccionado = 1; metodoSeleccionado <= 6; metodoSeleccionado++) { 
            System.out.println("");
            System.out.println(" Método: " + TClasificador.getMethodName(metodoSeleccionado));
            System.out.println(" Orden inicial (un solo vector):");
            System.out.println("      >  Ascendente: " + medidor.medir(TClasificador.copiar(vectorAscendente), metodoSeleccionado) + " ns");
            System.out.println("      > Descendente: " + medidor.medir(TClasificador.copiar(vectorDescendente), metodoSeleccionado) + " ns");
            System.out.println("      >   Aleatorio: " + medidor.medir(TClasificador.copiar(vectorAleatorio), metodoSeleccionado) + " ns");
            System.out.println(" Promedio con conjunto de " + tamanioConjuntoPromedio + " vectores");
            System.out.println("      >  Ascendente: " + medidor.medirPromedio(TClasificador.copiarConjunto(conjuntoParaPromediarAsc), metodoSeleccionado) + " ns");
            System.out.println("      > Descendente: " + medidor.medirPromedio(TClasificador.copiarConjunto(conjuntoParaPromediarDes), metodoSeleccionado) + " ns");
            System.out.println("      >   Aleatorio: " + medidor.medirPromedio(TClasificador.copiarConjunto(conjuntoParaPromediarAle), metodoSeleccionado) + " ns");
        }
    }

    public static void main(String[] args) {
        
        // Procedimiento 1
        obtenerMedidas(300, 100);
        obtenerMedidas(3000, 100);
        obtenerMedidas(30000, 100);
        
        // Procedimiento 2 noCascara = true
        
        
        // Procedimiento 3 noCascara = false
        
        
        
        
    }

}
