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
    //private HashMap <String,Asignaturas> asignaturasVigentes = new HashMap();
    private int añoIngreso;
    private String rut;
    
    
    /*public HashMap<String, Asignaturas> getAsignaturasVigentes() {
        return asignaturasVigentes;
    }

    
    public void setAsignaturasVigentes(HashMap<String, Asignaturas> asignaturasVigentes) {
        this.asignaturasVigentes = asignaturasVigentes;
    }*/  

    public Estudiante(String nombreEstudiante, int añoIngreso, String rut) {
        this.nombreEstudiante = nombreEstudiante;
        this.añoIngreso = añoIngreso;
        this.rut = rut;
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
    
    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public void agregarAsignaturas(String nombre, String id){
        Asignatura asignatura = new Asignatura(nombre, id);
        asignaturasAprobadas.add(asignatura);
    }
    
}

