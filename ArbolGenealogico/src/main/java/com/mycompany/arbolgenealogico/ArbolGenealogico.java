/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolgenealogico;

import java.util.Iterator;

/**
 *
 * @author start
 */
public class ArbolGenealogico {

    public static void main(String[] args) {
       //abuelos maternos
        BinaryTree<Familiar> mariaEmilia = new BinaryTree<>(
                new Familiar("Maria Emilia", 72, "Ama de casa", true, "Alamos, Sonora"));
        BinaryTree<Familiar> paisano = new BinaryTree<>(
                new Familiar("Paisano", 79, "Agricultor", false, "Navojoa, Sonora"));

        //abuelos paternos
        BinaryTree<Familiar> juanita = new BinaryTree<>(
                new Familiar("Juanita", 73, "Comerciante", true, "Huatabampo, Sonora"));
        BinaryTree<Familiar> rolandoAbuelo = new BinaryTree<>(
                new Familiar("Rolando", 75, "Jubilado", false, "Navojoa, Sonora"));

        //hijos (yo y mi hermano)
        BinaryTree<Familiar> tania = new BinaryTree<>(
                new Familiar("Tania", 19, "Estudiante", false, "Navojoa, Sonora"));
        BinaryTree<Familiar> jonathan = new BinaryTree<>(
                new Familiar("Jonathan", 26, "Ingeniero", false, "Navojoa, Sonora"));

        //subarbol paterno, abuelos y nietos
        BinaryTree<Familiar> juanitaConNieto = new BinaryTree<>(
                new Familiar("Juanita", 73, "Comerciante", true, "Huatabampo, Sonora"),
                jonathan,
                null
        );

        BinaryTree<Familiar> rolandoAbueloConNieta = new BinaryTree<>(
                new Familiar("Rolando", 75, "Jubilado", false, "Navojoa, Sonora"),
                null,
                tania
        );
        
        //subarbol materno, abuelos y nietos
        BinaryTree<Familiar> rolandoPadre = new BinaryTree<>(
                new Familiar("Rolando", 48, "Tecnico", false, "Navojoa, Sonora"),
                juanitaConNieto,
                rolandoAbueloConNieta
        );

        BinaryTree<Familiar> ramaMaterna = new BinaryTree<>(
                new Familiar("Maria Emilia", 72, "Ama de casa", true, "Alamos, Sonora"),
                paisano,
                null
        );

        //raiz del arbol mama
        BinaryTree<Familiar> arbolFamiliar = new BinaryTree<>(
                new Familiar("Yessica", 46, "Contadora", false, "Navojoa, Sonora"),
                ramaMaterna,
                rolandoPadre
        );

        System.out.println("Numero de nodos: " + arbolFamiliar.getNumberNodes());
        System.out.println("Altura del arbol: " + arbolFamiliar.getHeight());
        System.out.println(" ");
        System.out.println("\nRECORRIDO PREORDEN (Rai-Izq-Der)");
        mostrarRecorrido(arbolFamiliar.getPreorderIterator());
        System.out.println("\nRECORRIDO POSTORDEN (Izq-Der-Raiz)");
        mostrarRecorrido(arbolFamiliar.getPostorderIterator());
    }

    private static void mostrarRecorrido(Iterator<Familiar> iterador) {
        while (iterador.hasNext()) {
            System.out.println(" - " + iterador.next());
        }
    }
    
}
