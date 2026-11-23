/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolgenealogico;

import java.util.Iterator;

/**
 *
 * @author start
 */
public interface ITreeIterator<T> { //iterador: recorrer
    //poner 3 funciones en nuestra interfaz
    //tiene que pasar por estos y cumplir con ellos
    
    public Iterator<T> getInorderIterator();//1 se va primero de izquierda, raiz, derecho
    
    public Iterator<T> getPreorderIterator();//2 izquierda derecho raiz
    
    public Iterator<T> getPostorderIterator();//3 primero derecho izquierdo raiz
    
    
}
