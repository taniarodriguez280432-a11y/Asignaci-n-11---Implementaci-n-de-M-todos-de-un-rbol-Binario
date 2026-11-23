/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolgenealogico;

/**
 *
 * @author start
 */
public class Familiar {

    private String nombre;
    private int edad;
    private String ocupacion;
    private boolean finado;
    private String lugarNacimiento;

    public Familiar(String nombre, int edad, String ocupacion, boolean finado, String lugarNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.finado = finado;
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public boolean isFinado() {
        return finado;
    }

    public void setFinado(boolean finado) {
        this.finado = finado;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    @Override
    public String toString() {
        String estado = finado ? "Finado" : "Vivo";
        return "Familia{"
                + "nombre='" + nombre + '\''
                + ", edad=" + edad
                + ", ocupacion='" + ocupacion + '\''
                + ", estado=" + estado
                + ", lugarNacimiento='" + lugarNacimiento + '\''
                + '}';
    }

}
