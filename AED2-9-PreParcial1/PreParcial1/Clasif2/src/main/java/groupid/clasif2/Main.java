/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package groupid.clasif2;

/**
 *
 * @author July
 */
public class Main {

    public static void main(String[] args) {
        TClasificador clasif = new TClasificador();
	GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();	
        int[] vectorDescendente = gdg.generarDatosDescendentes();
        
        System.out.println("***********  SELECCION  ***********");
	int[] resAleatorio = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_SELECCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendente = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_SELECCION);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendente = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_SELECCION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        
        System.out.println("\n");
        System.out.println("***********  HEAPSORT  ***********");
	int[] resAleatorioHeap = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_HEAPSORT);
        for (int i = 0; i < resAleatorioHeap.length; i++) {
            System.out.print(resAleatorioHeap[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteHeap = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_HEAPSORT);
        for (int i = 0; i < resAscendenteHeap.length; i++) {
            System.out.print(resAscendenteHeap[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendenteHeap = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_HEAPSORT);
        for (int i = 0; i < resDescendenteHeap.length; i++) {
            System.out.print(resDescendenteHeap[i] + " ");
        }
        
        System.out.println("\n");
        System.out.println("***********  CUENTA  ***********");
	/*int[] resAleatorioCuenta = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_CUENTA);
        for (int i = 0; i < resAleatorioCuenta.length; i++) {
            System.out.print(resAleatorioCuenta[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteCuenta = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_CUENTA);
        for (int i = 0; i < resAscendenteCuenta.length; i++) {
            System.out.print(resAscendenteCuenta[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendenteCuenta = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_CUENTA);
        for (int i = 0; i < resDescendenteCuenta.length; i++) {
            System.out.print(resDescendenteCuenta[i] + " ");
        }*/
        
        System.out.println("\n");
        System.out.println("***********  BINSORT  ***********");
	int[] resAleatorioBinsort = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_BINSORT);
        for (int i = 0; i < resAleatorioBinsort.length; i++) {
            System.out.print(resAleatorioBinsort[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteBinsort = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_BINSORT);
        for (int i = 0; i < resAscendenteBinsort.length; i++) {
            System.out.print(resAscendenteBinsort[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendenteBinsort = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_BINSORT);
        for (int i = 0; i < resDescendenteBinsort.length; i++) {
            System.out.print(resDescendenteBinsort[i] + " ");
        }
        
        System.out.println("\n");
        System.out.println("***********  RADIXSORT  ***********");
	int[] resAleatorioRadix = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_RADIXSORT);
        for (int i = 0; i < resAleatorioRadix.length; i++) {
            System.out.print(resAleatorioRadix[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteRadix = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_RADIXSORT);
        for (int i = 0; i < resAscendenteRadix.length; i++) {
            System.out.print(resAscendenteRadix[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendenteRadix = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_RADIXSORT);
        for (int i = 0; i < resDescendenteRadix.length; i++) {
            System.out.print(resDescendenteRadix[i] + " ");
        }
        
    }
}
