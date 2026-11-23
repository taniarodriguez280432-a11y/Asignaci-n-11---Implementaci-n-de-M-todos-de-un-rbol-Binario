/*
- Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
- Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.arbolgenealogico;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;



/**
 *
- @author start
 */
public class BinaryTree <T> extends BinaryTreeComun<T> implements ITreeIterator<T>{//arbol bueno
    
    //hacer una fumada, iteracion en orden :p
    
    class InorderIterator implements Iterator<T>{
    private Stack<NodoArbolBinario<T>> pilaNodos;//con la pila haremos el recorrido ordenado
    private NodoArbolBinario<T> nodoActual;//el que va a ir apuntando
    
    public InorderIterator(){//constructor de la pila
        //Pila para almacenar los nodos izquierdos
    pilaNodos = new Stack<>();
    nodoActual = raiz; //este nodo sera la raiz
    //inserta en la pila el subarbol izuqierdo de la raiz
    pushSubArbolIzquierdo(nodoActual);
        
    }
    
    private void pushSubArbolIzquierdo(NodoArbolBinario<T> nodoActual){
        while(nodoActual!= null){
            pilaNodos.push(nodoActual);
            nodoActual = nodoActual.hijoIzq;
        }
    }

        @Override
        public boolean hasNext() {
            return !pilaNodos.empty();
        }

        @Override
        public T next() {
            NodoArbolBinario<T> nodoSig = null;
            if(!pilaNodos.empty()){
                nodoSig = pilaNodos.pop();
                pushSubArbolIzquierdo(nodoSig.hijoDer);
            }else {
                throw new NoSuchElementException();
            }
            return nodoSig.dato;
        }
    }

    class PreorderIterator implements Iterator<T> {
        private Stack<NodoArbolBinario<T>> pilaNodos;

        public PreorderIterator() {
            pilaNodos = new Stack<>();
            if (raiz != null) {
                pilaNodos.push(raiz);
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaNodos.empty();
        }

        @Override
        public T next() {
            if (!pilaNodos.empty()) {
                NodoArbolBinario<T> nodoSig = pilaNodos.pop();
                if (nodoSig.hijoDer != null) {
                    pilaNodos.push(nodoSig.hijoDer);
                }
                if (nodoSig.hijoIzq != null) {
                    pilaNodos.push(nodoSig.hijoIzq);
                }
                return nodoSig.dato;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    class PostorderIterator implements Iterator<T> {
        private Stack<NodoArbolBinario<T>> pilaNodos;
        private Stack<NodoArbolBinario<T>> pilaSalida;

        public PostorderIterator() {
            pilaNodos = new Stack<>();
            pilaSalida = new Stack<>();
            if (raiz != null) {
                pilaNodos.push(raiz);
                while (!pilaNodos.empty()) {
                    NodoArbolBinario<T> nodoSig = pilaNodos.pop();
                    pilaSalida.push(nodoSig);
                    if (nodoSig.hijoIzq != null) {
                        pilaNodos.push(nodoSig.hijoIzq);
                    }
                    if (nodoSig.hijoDer != null) {
                        pilaNodos.push(nodoSig.hijoDer);
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaSalida.empty();
        }

        @Override
        public T next() {
            if (!pilaSalida.empty()) {
                return pilaSalida.pop().dato;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
            
    //al implementar los metodos abstractos se vienen getInorderIterator getPreorderIterator getPostorderIterator
    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return new PostorderIterator();
    }
    
    
    //hacemos constructores
    public BinaryTree(){
        raiz = null; //instanciamos un arbol y esta vacio(la raiz no tiene nada)
    }
    
    //creamos otro metodo y otro constructor y este si recibe un dato
    public BinaryTree(T datoRaiz){
        raiz = new NodoArbolBinario(datoRaiz); //polimorfismo, se pueden crear en una misma clase varios metodos/constructores en una misma clase
                                                //se diferencian con las firmas(parametros) de la clase "(T datoRaiz)"
    }
    
    public BinaryTree(T datoRaiz, BinaryTree<T> arbolDer, BinaryTree<T> arbolIzq){
       setTree(datoRaiz, arbolIzq, arbolDer); 
        
    }
    
    //hacer una funcion
    //toma dos arboles y apartir de estos dos hace la estructura:
    private void setTree(T datoRaiz, BinaryTree<T> arbolIzq, BinaryTree<T> arbolDer){
        raiz = new NodoArbolBinario(datoRaiz);
        if((arbolIzq !=null) && !arbolIzq.empty()){//si el arbol izquierod no es nulo y no esta vacio
            raiz.hijoIzq = copy(arbolIzq.raiz);//entramos aqui (asigna como hijo izquierdo de la raiz al arbol izquierdo)
        }
        if((arbolDer !=null) && !arbolDer.empty()){//
            raiz.hijoDer = copy(arbolDer.raiz);
        }
    }
    
    private NodoArbolBinario<T> copy(NodoArbolBinario<T> nodo){
        NodoArbolBinario <T> nuevoNodo = new NodoArbolBinario<>(nodo.dato);
        if(nodo.hijoIzq != null){
            nuevoNodo.hijoIzq = copy(nodo.hijoIzq);
        }
        if(nodo.hijoDer != null){
            nuevoNodo.hijoDer = copy(nodo.hijoDer);
        }
        return nuevoNodo;
    }
    
    
}