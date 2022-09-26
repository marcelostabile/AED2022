package groupid.arbolgeneral;

public class TArbolGen {
    
    private TNodoAG raiz;

    public TArbolGen() {}

    public TArbolGen(TNodoAG raiz) {
        this.raiz = raiz;
    }

    public TNodoAG getRaiz() {
        return raiz;
    }

    public void setRaiz(TNodoAG raiz) {
        this.raiz = raiz;
    }
    
    public boolean insertar (Comparable etiqueta, Comparable etiquetaPadre){
        if (raiz == null && etiquetaPadre == null){
            TNodoAG nodo = new TNodoAG(etiqueta, etiquetaPadre);
            this.raiz = nodo;
            return true;
        }else if (raiz == null && etiquetaPadre != null){
            return false; // La raiz no puede tener padre.
        }else if (raiz != null && etiquetaPadre == null){
            return false;// Ya existe raiz, y por tanto no se puede ingresar una nueva
        }else{
            return raiz.insertar(etiqueta, etiquetaPadre);
        }       
    }

    public TNodoAG buscar (Comparable unaEtiqueta){
        if (raiz != null) {
            if (raiz.getEtiqueta() == unaEtiqueta) {
                return raiz;
            }
            else {
                return raiz.buscar(unaEtiqueta);
            }
        }
        else {
            return null;
        }
    }
    
    public int[] listarIndentado (){
        int profundidad = 0;
        int maxProfundidad [] = {-1};        
        if (raiz == null){
            System.out.println("El árbol está vacío");
        }else{ 
            maxProfundidad[0] = 0;
            raiz.listarIndentado(profundidad, maxProfundidad);
        }
        return maxProfundidad;
    }
    
    public void imprimirEtiquetas(){
        if(raiz!=null){
            raiz.imprimir();
        }
    }
    public int contarPalabras(){//Tamaño
        int [] cont={0};
        if(raiz!=null){
             raiz.contarPalabras(cont);
             return cont[0];
        }
        else{
            return 0;
        }
    }
    public int hojas(){
        int [] conta={0};
        if(raiz!=null){
            raiz.hojas(conta);
            return conta[0];
        }
        else{
            return 0;
        }
    }
    public int nivel(Comparable etiqueta){
        int [] cont={0};
        if(raiz!=null){
            raiz.nivel(cont,etiqueta);
            return cont[0];
        }
        else{
            return 0;
        }
    }
    
    
}
