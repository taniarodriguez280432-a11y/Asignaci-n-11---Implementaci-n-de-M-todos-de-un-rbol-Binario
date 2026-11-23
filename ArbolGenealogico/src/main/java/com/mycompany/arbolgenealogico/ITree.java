/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolgenealogico;

/**
 *
 * @author start
 */
public interface ITree<T> {//esta interfaz sirve en general para arbol
    
    public T getRootData(); //devuelve el valor de la raiz
    
    public int getHeight();//obtener la altura del arbol
    
    public int getNumberNodes();//obtener el numero de nodos que tiene el arbol
    
    public boolean empty();//nos dice si esta vacio o no
    
    public void clear();//sirve para limpiar
    
}
