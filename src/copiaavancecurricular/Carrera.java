/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copiaavancecurricular;

import java.util.*;;
import java.io.*;
import java.text.*;


public class Carrera {
    private String nombre;
    private HashMap <String, Estudiante> mapAlumnosTotal = new HashMap();
    private HashMap <String, Asignatura> mapRamosTotal = new HashMap();
    private ArrayList <Estudiante> listAlumnosTotal = new ArrayList();
    private ArrayList <Asignatura> listAsignaturasTotal = new ArrayList();

    public Carrera(){
        nombre = null;
        mapAlumnosTotal = new HashMap();
        mapRamosTotal = new HashMap();
        listAlumnosTotal = new ArrayList();
        listAsignaturasTotal = new ArrayList();
    }
    public Carrera(String nombre) {
        this.nombre = nombre;
        mapAlumnosTotal = new HashMap();
        mapRamosTotal = new HashMap();
        listAlumnosTotal = new ArrayList();
        listAsignaturasTotal = new ArrayList();
    }


    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    
    // ASIGNATURAS AL SISTEMA POR CARRERA
    public boolean annadirRamo (Asignatura aa){
        /* retorna true si la asignatura se agregó, y false si no lo hizo*/
        if(!mapRamosTotal.containsKey(aa.getId())){
            listAsignaturasTotal.add(aa);
            mapRamosTotal.put(aa.getId(), aa);
            return true;
        }
        return(false);
    }
    public Asignatura buscarAsignatura(String id){
        if(mapRamosTotal.containsKey(id)){
            return (Asignatura) mapRamosTotal.get(id);
        }
        return null;
    }
    public void mostrarRamos(){
        int j = listAsignaturasTotal.size();
        if(j == 0){
            System.out.println("Carrera sin asignaturas en el sistema :c");
            System.out.println("");
            return;
        }
        Asignatura aux;
        System.out.println("Asignaturas de la carrera: ");
        for (int i = 0; i<j; i++) {
            aux = (Asignatura)listAsignaturasTotal.get(i);
            System.out.print(aux.getId()+": ");
            System.out.println(aux.getNombre());
        }
        System.out.println("");
    }
    
    // ESTUDIANTES
    public boolean agregarEstudiante (Estudiante ee) throws RutException{
        /* retorna true si la asignatura se agregó, y false si no lo hizo*/
        String rut = ee.getRut();
        String lastChar = Character.toString(rut.charAt(rut.length() - 1));
        if ((lastChar.equals("k")) || (lastChar.equals("K"))){ 
            if(buscarEstudiante(ee.getRut()) == null){
                listAlumnosTotal.add(ee);
                mapAlumnosTotal.put(ee.getRut(), ee);
                return true;
            }
        }
        try {
        int numAux = NumberFormat.getInstance().parse(lastChar).intValue();
            if (numAux >= 0 && numAux <= 9) {
                if (buscarEstudiante(ee.getRut()) == null) {
                    listAlumnosTotal.add(ee);
                    mapAlumnosTotal.put(ee.getRut(), ee);
                    return true;
                }
            } 
            else {
                throw new RutException();
            }
        } catch (ParseException e) {
            throw new RutException();
        }
        return false;
    }
    public Estudiante buscarEstudiante(String rut){
        /* retorna true si la asignatura NO existe, y false si existe*/
        if(mapAlumnosTotal.containsKey(rut)){
            return (Estudiante) mapAlumnosTotal.get(rut);
        }
        return null;
    }
    public void listarEstudiantes(){
        int j = listAlumnosTotal.size();
        if(j == 0){
            System.out.println("Carrera sin alumnos :c");
            System.out.println("");
            return;
        }
        Estudiante aux;
        System.out.println("Alumnos de la carrera: ");
        for (int i = 0; i<j; i++) {
            aux = (Estudiante)listAlumnosTotal.get(i);
            System.out.print(aux.getRut()+": ");
            System.out.println(aux.getNombre());
        }
        System.out.println("");
    }
    public boolean agregarAsignatura(String rut, String id){
        Estudiante ee = buscarEstudiante(rut);
        Asignatura aa = buscarAsignatura(id);
        if(ee == null){
            return false;
        }
        if(aa == null){
            return false;
        }
        
        return ee.agregarAsignatura(aa.getNombre(), aa.getId(), aa.getNota());
    }
    public boolean agregarAsignatura(String rut)throws IOException{
        Estudiante ee = buscarEstudiante(rut);
        if(ee == null){
            return false;
        }
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        mostrarRamos();
        
        System.out.println("Ingrese ID de la asignatura aprobada: ");
        String id = leer.readLine();
        
        if(buscarAsignatura(id) == null){
            return false;
        }
        Asignatura aa = buscarAsignatura(id);
        return ee.agregarAsignatura(aa.getNombre(), aa.getId(), aa.getNota());
    }
    
    public boolean modificarNota(String rut, String id) throws IOException{
        Estudiante ee = buscarEstudiante(rut);
        if (ee == null)
            return false;
        
        return ee.modificarNota(id);
        
    }
    
    public boolean eliminarAsignatura(String rut, String id){
        Estudiante ee = buscarEstudiante(rut);
        if (ee == null)
            return false;
        
        return ee.eliminarAsignatura(id);
    }
    
    public void mostarPorNotaMin(int nota, String id){
        int j = listAlumnosTotal.size();
        if(j == 0){
            System.out.println("Carrera sin alumnos :c");
            System.out.println("");
            return;
        }
        Estudiante aux;
        System.out.println("Alumnos con nota minima >= "+nota);
        for (int i = 0; i<j; i++) {
            aux = (Estudiante)listAlumnosTotal.get(i);
            if (aux.mostarPorNotaMin(nota, id)){
                System.out.println(aux.getNombre());
            }
        }
        System.out.println("");
    }
}
