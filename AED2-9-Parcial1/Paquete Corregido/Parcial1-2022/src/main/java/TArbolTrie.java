/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class TArbolTrie {
    
    TNodoTrie raiz;
    
    public TArbolTrie(){
         raiz = new TNodoTrie();
    }
    
    public void insertar(String s){
        raiz.insertar(s);
    }
    
    public TNodoTrie buscar(String s){
        return raiz.buscar(s);
    } 
    
    public void imprimir(){
        raiz.imprimir();
    }
    
    public String[] listarRegistros() {
        return raiz.listar();
    }
    
}
