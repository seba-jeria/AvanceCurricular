/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copiaavancecurricular;

/**
 *
 * @author seba
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;


/**
 *
 * @author seba
 */
public class Estudiante {
    private String nombreEstudiante;
    private ArrayList<Asignatura> asignaturasAprobadas = new ArrayList();
    private String añoIngreso;
    private String rut;

    public Estudiante(String nombreEstudiante, String añoIngreso, String rut) {
        this.nombreEstudiante = nombreEstudiante;
        this.añoIngreso = añoIngreso;
        this.rut = rut;
    }
    
    public Estudiante() {
        this.nombreEstudiante = null;
        this.añoIngreso = null;
        this.rut = null;
    }

    public ArrayList<Asignatura> getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    public void setAsignaturasAprobadas(ArrayList<Asignatura> asignaturasAprobadas) {
        this.asignaturasAprobadas = asignaturasAprobadas;
    }
    
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    
    public String getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(String añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    //Se encarga de agregar una asignatura a la lista de asignaturasAprobadas
    public void agregarAsignaturas(String nombre, String id){
        Asignatura asignatura = new Asignatura(nombre, id);
        asignaturasAprobadas.add(asignatura);
    }
}