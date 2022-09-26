package groupid.arbolgeneral;

public class Main {
    public static void main(String[] args) throws Exception {

        TArbolGen organUCU = new TArbolGen();
        
        organUCU.insertar("RECTORIA", null);
        organUCU.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        organUCU.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO", "RECTORIA");
        organUCU.insertar("VICERRECTORIA ACADEMICA", "RECTORIA");
        organUCU.insertar("VICERRECTORIA ADMINISTRATIVA", "RECTORIA");
        organUCU.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORIA ACADEMICA");
        organUCU.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORIA ACADEMICA");
        organUCU.insertar("FACULTAD DE INGENIERIA Y TECNOLOGIAS", "VICERRECTORIA ACADEMICA");
        organUCU.insertar("FACULTAD DE PSICOLOGIA", "VICERRECTORIA ACADEMICA");
        organUCU.insertar("FACULTAD DE PSICOLOGIA", "VICERRECTORIA ACADEMICA");
        organUCU.insertar("DEPARTAMENTO DE INFORMATICA Y CIENCIAS DE LA COMPUTACION", "FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        organUCU.insertar("DEPARTAMENTO DE INGENIERIA ELECTRICA", "FACULTAD DE INGENIERIA Y TECNOLOGIAS");        
        organUCU.insertar("DEPARTAMENTO DE INGENIERIA ELECTRIC{}A", "FACULTAD DE INGENIERIA Y TECNOLOGIAS");        
        organUCU.insertar("DEPARTAMENTO DE MATEMATICAS", "FACULTAD DE INGENIERIA Y TECNOLOGIAS");
       
        System.out.println("******************************************************");
        System.out.println(organUCU.buscar("DEPARTAMENTO DE MATEMATICAS").getEtiqueta());
        System.out.println("******************************************************");

        int[] lista = organUCU.listarIndentado ();
        

    }
}
