/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copiaavancecurricular;
import java.io.*;

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
    private String nombre;
    private String rut;
    private String annoIngreso;
    private ArrayList<Asignatura> asignaturasVigentes = new ArrayList();
    private ArrayList<Asignatura> asignaturasAprobadas = new ArrayList();
    
    

    public Estudiante(String nombreEstudiante, String annoIngreso, String rut) {
        this.nombre = nombreEstudiante;
        this.annoIngreso = annoIngreso;
        this.rut = rut;
        asignaturasAprobadas = new ArrayList();
        asignaturasVigentes = new ArrayList();
    }
    
    public Estudiante() {
        this.nombre = null;
        this.annoIngreso = null;
        this.rut = null;
        asignaturasAprobadas = new ArrayList();
        asignaturasVigentes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getAnnoIngreso() {
        return annoIngreso;
    }
    public void setAnnoIngreso(String annoIngreso) {
        this.annoIngreso = annoIngreso;
    }

    

    public void mostrarAprobadas (){
        int j = asignaturasAprobadas.size();
        if(j == 0){
            System.out.println("Estudiante sin asignaturas aprobadas :c");
            System.out.println("");
            return;
        }
        Asignatura aux;
        System.out.println("Asignaturas aprobadas: ");
        for (int i = 0; i<j; i++) {
            aux = (Asignatura)asignaturasAprobadas.get(i);
            System.out.print(aux.getId()+": ");
            System.out.println(aux.getNombre());
            System.out.println("Nota: "+aux.getNota());
        }
        System.out.println("");
    }
    
    //Se encargan de agregar una asignatura a la lista de asignaturasAprobadas
    public boolean agregarAsignatura (String nombre, String id, int nota){
       
       /* retorna true si la asignatura se agregó, y false si no lo hizo*/
        if(buscarAsignatura(id) == null){
            Asignatura aa = new Asignatura(nombre, id, nota);
            asignaturasAprobadas.add(aa);
            return true;
        }
        return(false);
   }
    public boolean agregarAsignatura (Asignatura aa){
        /* retorna true si la asignatura se agregó, y false si no lo hizo*/
        if(buscarAsignatura(aa.getId()) == null){
            asignaturasAprobadas.add(aa);
            return true; 
        }
        
        return(false);
    }     
   
    
    public Asignatura buscarAsignatura(String id){
        int j = asignaturasAprobadas.size();
        Asignatura aux;
        for(int i = 0; i<j; i++){
            aux = (Asignatura)asignaturasAprobadas.get(i);
            if(id.equals(aux.getId())){
                return aux;
            }
        }
        return null;
    }
    
    public boolean modificarNota(String id) throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Asignatura aa = buscarAsignatura(id);
        if (aa != null){
            System.out.println("Ingrese nota:");
            Double nota = Double.parseDouble(leer.readLine());
            aa.setNota(nota);
            return true;
        }
        return false;
    }
    
    public boolean eliminarAsignatura(String id){
        Asignatura aa = buscarAsignatura(id);
        if (aa == null)
            return false;
 
        asignaturasAprobadas.remove(aa);
        return true;
    }
    
    public boolean mostarPorNotaMin(int nota, String id){
        Asignatura aa = buscarAsignatura(id);
        if (aa == null)
            return false;
        return nota <= aa.getNota();
    }
}