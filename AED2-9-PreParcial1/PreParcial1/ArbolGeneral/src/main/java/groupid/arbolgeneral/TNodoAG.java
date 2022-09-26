package groupid.arbolgeneral;
public class TNodoAG {
    
    private Comparable etiqueta;
    private Comparable etiquetaPadre;
    private TNodoAG primerHijo;
    private TNodoAG sigHermano;

    public TNodoAG(Comparable etiqueta, Comparable etiquetaPadre) {
        this.etiqueta = etiqueta;
        this.etiquetaPadre = etiquetaPadre;
        this.primerHijo = null;
        this.sigHermano = null;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public Comparable getEtiquetaPadre() {
        return etiquetaPadre;
    }

    public TNodoAG getPrimerHijo() {
        return primerHijo;
    }

    public TNodoAG getSigHermano() {
        return sigHermano;
    }
    
    public boolean insertar (Comparable unaEtiqueta, Comparable unaEtiquetaPadre){
        boolean resultado = false;
        
        if (unaEtiquetaPadre.compareTo(this.etiqueta)==0){
            if(this.primerHijo == null){
                TNodoAG hijo = new TNodoAG(unaEtiqueta, unaEtiquetaPadre);
                this.primerHijo = hijo;
                return true;
            }else{
                TNodoAG hijoTemp = this.primerHijo;
                TNodoAG hijoAnterior = null;
                while (hijoTemp != null){
                    if ( hijoTemp.etiqueta == unaEtiqueta){
                        return false; //El elemento había sido ingresado con anterioridad
                    }
                    hijoAnterior = hijoTemp; //Mantengo una referencia al ultimo hijo
                    hijoTemp = hijoTemp.sigHermano;
                }
                TNodoAG nuevoHijo = new TNodoAG(unaEtiqueta, unaEtiquetaPadre);
                hijoAnterior.sigHermano = nuevoHijo;
                return true;
            }
        }else{
            TNodoAG unHijo = this.primerHijo;
            while (unHijo != null){
                resultado = unHijo.insertar(unaEtiqueta, unaEtiquetaPadre);
                if (resultado == true){
                    return resultado;
                }else{
                    unHijo = unHijo.sigHermano;
                }
            }
        }
        return resultado;
    }
    
    public TNodoAG buscar(Comparable unaEtiqueta){
        TNodoAG resultado = null;
        //Si encuentra la etiqueta la devuelve
        if (this.etiqueta == unaEtiqueta) {
            resultado = this;
            return resultado;
        }
        else {
            //Asignamos el primer hijo
            TNodoAG unHijo = this.primerHijo;
            //Recorremos el arbol mientras es distinto a null
            while (unHijo != null) {
                resultado = unHijo.buscar(unaEtiqueta);
                if (resultado == null) {
                    unHijo = unHijo.sigHermano;
                }
                else{
                    //Porque ?????? 
                    return resultado;
                }
            }
            return resultado;
        }
    }
    
    public void listarIndentado(int profundidad, int[] maxProfundidad){
        if (profundidad > maxProfundidad[0]){
            maxProfundidad[0]= profundidad; //Solo se actualiza cuando aumenta la profundidad.
        }
        String indentacion = "";
        for (int i = 0; i < profundidad; i++) {
            indentacion += "\t";            
        }        
        System.out.println(indentacion + this.etiqueta);
        TNodoAG unHijo = this.primerHijo;
        while (unHijo != null){            
            unHijo.listarIndentado(profundidad+1, maxProfundidad);
            unHijo = unHijo.sigHermano;
        }
    }

    public void imprimir() {
        System.out.println(this.etiqueta);
        TNodoAG unHijo = this.primerHijo;
        while(unHijo != null){
            unHijo.imprimir();
            unHijo = unHijo.sigHermano; 
        }
    }
    
    public void contarPalabras(int [] cont){
        //para filtar poner: if(this.etiqueta="VICERRECTORIA DEL MEDIO UNIVERSITARIO") {cont[0]++} por ej
        cont [0]++;
        TNodoAG unHijo = this.primerHijo;
        while(unHijo != null){
            unHijo.contarPalabras(cont);
            unHijo = unHijo.sigHermano;
        }
     }

    public void hojas(int[] conta) {
        TNodoAG unHijo= this.primerHijo;
        if(unHijo==null){
            conta [0]++;
        }
        while(unHijo!=null){
            unHijo.hojas(conta);
            unHijo=unHijo.sigHermano;
        }
    }
    
    public void nivel(int[] cont,Comparable etiqueta) {
        boolean bandera=false;
        TNodoAG unHijo= this.primerHijo;
        if(unHijo==null && bandera==false){
            cont [0]++;
        }
        if(this.etiqueta.compareTo(etiqueta)==0){
            bandera=true;
        }
        while(unHijo!=null && bandera==false){
            unHijo.nivel(cont,etiqueta);
            unHijo=unHijo.sigHermano;
        }
    }
    
}
