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

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public void setNota(Double nota){
        this.nota = (int) (nota*10);
    }

}
