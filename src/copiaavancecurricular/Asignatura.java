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
    //se incializan las variables
    private String nombre;
    private String id;
    private int nota;
    
    //se crea el contructor, al cual se le pasan los parametros
    public Asignatura(String nombreAsignatura, String idAsignatura, int nota) {
        this.nombre = nombreAsignatura;
        this.id = idAsignatura;
        this.nota = nota;
    }
    //se crea el constructor, al cual no se le pasa ningun parametro
    public Asignatura(String nombreAsignatura, String idAsignatura) {
        this.nombre = nombreAsignatura;
        this.id = idAsignatura;
        this.nota = 40;
    }
    
    //se crean los sets y gets
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
    
    //comprueba que la nota sea ingresada correctamente y la asigna a la variable correspondiente
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
