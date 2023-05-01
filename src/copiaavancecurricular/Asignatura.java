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

/**
 *
 * @author seba
 */
public class Asignatura {
    private String nombre;
    private String id;
    private int nota;
    
    public Asignatura(String nombreAsignatura, String idAsignatura, int nota) {
        this.nombre = nombreAsignatura;
        this.id = idAsignatura;
        this.nota = nota;
    }
    public Asignatura(String nombreAsignatura, String idAsignatura) {
        this.nombre = nombreAsignatura;
        this.id = idAsignatura;
        this.nota = 40;
    }
    
    public Asignatura(){
        this.nombre = null;
        this.id = null;
        this.nota = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }
    
    public void setNota(Double nota){
        double redondeado = Math.round(nota * 10) / 10.0;

        if (redondeado < 10) {
            redondeado = redondeado * 10;
            redondeado = (int) redondeado;
        } else {
            redondeado = (int) redondeado;
        }

        int numeroEntero = (int) redondeado;
        this.nota = numeroEntero;
    }
}
