/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolgenealogico;

/**
 *
 * @author start
 */
public class BinaryTreeComun<T> implements ITree<T> {//arbol malo

    NodoArbolBinario<T> raiz; //seria como el inicio de una lista, el primero de uan fila

    class NodoArbolBinario<T> {

        T dato;
        NodoArbolBinario<T> hijoIzq;
        NodoArbolBinario<T> hijoDer;

        public NodoArbolBinario(T dato) {
            this.dato = dato;
        }
    }

    @Override
    public T getRootData() {
        if (raiz == null) {
            return null;
        }

        return raiz.dato;

    }

    @Override
    public int getHeight() {
        return getHeight(raiz);
      
    }

    protected int getHeight(NodoArbolBinario<T> nodo) { //da la altura maxima del arbol
        int height = 0;
        if (nodo != null) {
            height = 1 + Math.max(getHeight(nodo.hijoIzq),
                    getHeight(nodo.hijoDer));
        }
        return height;
    }

    @Override
    public int getNumberNodes() {
        return getNumberNodes(raiz);
    }

    private int getNumberNodes(NodoArbolBinario<T> nodo) { //cuenta el numero de nodos que hay en el arbol
        if (nodo == null) {
            return 0;
        }
        int numNodosIzq = getNumberNodes(nodo.hijoIzq);
        int numNodosDer = getNumberNodes(nodo.hijoDer);

        return 1 + numNodosIzq + numNodosDer;

    }

    @Override
    public boolean empty() { //preguntar si un arbol esta vacio o no
        return raiz == null;//si no tiene raiz esta vacio
        
    }

    @Override
    public void clear() {
         raiz = null; //no hay nada
    }

}
