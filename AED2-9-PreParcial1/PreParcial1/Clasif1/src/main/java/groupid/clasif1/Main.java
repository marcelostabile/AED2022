package groupid.clasif1;

/**
 *
 * @author July
 */
public class Main {

    public static void main(String[] args)throws Exception {
        TClasificador clasif = new TClasificador();
	GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();	
        int[] vectorDescendente = gdg.generarDatosDescendentes();
        
        System.out.println("***********  INSERCION  ***********");
	int[] resAleatorio = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendente = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println("\n");
        int[] resDescendente = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        
        System.out.println("\n***********  SHELLSORT  ***********");
	int[] resAleatorioShell = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_SHELL);
        for (int i = 0; i < resAleatorioShell.length; i++) {
            System.out.print(resAleatorioShell[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteShell = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_SHELL);
        for (int i = 0; i < resAscendenteShell.length; i++) {
            System.out.print(resAscendenteShell[i] + " ");
        }
        System.out.println("\n");        
        int[] resDescendenteShell = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_SHELL);
        for (int i = 0; i < resDescendenteShell.length; i++) {
            System.out.print(resDescendenteShell[i] + " ");
        }
        
        System.out.println("\n***********  BURBUJA  ***********");
	int[] resAleatorioBurbuja = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_BURBUJA);
        for (int i = 0; i < resAleatorioBurbuja.length; i++) {
            System.out.print(resAleatorioBurbuja[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteBurbuja = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_BURBUJA);
        for (int i = 0; i < resAscendenteBurbuja.length; i++) {
            System.out.print(resAscendenteBurbuja[i] + " ");
        }
        System.out.println("\n");        
        int[] resDescendenteBurbuja = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_BURBUJA);
        for (int i = 0; i < resDescendenteBurbuja.length; i++) {
            System.out.print(resDescendenteBurbuja[i] + " ");
        }
        
        System.out.println("\n***********  QUICKSORT  ***********");
	int[] resAleatorioQuick = clasif.clasificar(vectorAleatorio,TClasificador.METODO_CLASIFICACION_QUICKSORT);
        for (int i = 0; i < resAleatorioQuick.length; i++) {
            System.out.print(resAleatorioQuick[i] + " ");
	}
        System.out.println("\n");
	int[] resAscendenteQuick = clasif.clasificar(vectorAscendente,TClasificador.METODO_CLASIFICACION_QUICKSORT);
        for (int i = 0; i < resAscendenteQuick.length; i++) {
            System.out.print(resAscendenteQuick[i] + " ");
        }
        System.out.println("\n");        
        int[] resDescendenteQuick = clasif.clasificar(vectorDescendente,TClasificador.METODO_CLASIFICACION_QUICKSORT);
        for (int i = 0; i < resDescendenteQuick.length; i++) {
            System.out.print(resDescendenteQuick[i] + " ");
        }
        
        
    }
}
