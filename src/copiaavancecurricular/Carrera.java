/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copiaavancecurricular;

import java.util.*;;
import java.io.*;
import java.text.*;


public class Carrera {
    //se inicializan las variables
    private String nombre;
    private HashMap <String, Estudiante> mapAlumnosTotal = new HashMap();
    private HashMap <String, Asignatura> mapRamosTotal = new HashMap();
    private ArrayList  listAlumnosTotal = new ArrayList();
    private ArrayList  listAsignaturasTotal = new ArrayList();
    
    //se crea un constructor sin parametros
    public Carrera(){
        nombre = null;
        mapAlumnosTotal = new HashMap();
        mapRamosTotal = new HashMap();
        listAlumnosTotal = new ArrayList();
        listAsignaturasTotal = new ArrayList();
    }
    
    //se crea un constructor que recibe el nombre de la carrera
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
    //busca la asignatura en el mapa
    public Asignatura buscarAsignatura(String id){
        if(mapRamosTotal.containsKey(id)){
            return (Asignatura) mapRamosTotal.get(id);
        }
        return null;
    }
    //muestra las asignaturas de una lista
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
    public boolean agregarEstudiante (EstudianteVigente ee) throws RutException{
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
    //agrega el estudiante ingresado por terminal a un mapa y una lista
    public boolean agregarEstudiante (EstudianteTitulado ee) throws RutException{
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
    //busca el estudiante en el mapa
    public Object buscarEstudiante(String rut){
        /* retorna true si la asignatura NO existe, y false si existe*/
        if(mapAlumnosTotal.containsKey(rut)){
            return (Estudiante) mapAlumnosTotal.get(rut);
        }
        return null;
    }
    //recorre la lista y muestra cada estudiante en la carrera
    public void listarEstudiantes(){
        int j = listAlumnosTotal.size();
        if(j == 0){
            System.out.println("Carrera sin alumnos :c");
            System.out.println("");
            return;
        }
        System.out.println("Alumnos de la carrera: ");
        for (int i = 0; i<j; i++) {
            if((listAlumnosTotal.get(i)) instanceof EstudianteVigente){
                EstudianteVigente aux = (EstudianteVigente)listAlumnosTotal.get(i);
                aux.identificarse();
            }
            else{
                EstudianteTitulado aux = (EstudianteTitulado)listAlumnosTotal.get(i);
                aux.identificarse();
            }
        }
        System.out.println("");
    }
    //ve si existe el estudiante y la carrera, para depues agregarlo a las asignaturas vigentes
    public boolean agregarAsignaturaVigente(String rut, String id){
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
        Asignatura aa = buscarAsignatura(id);
        if(ee == null){
            return false;
        }
        if(aa == null){
            return false;
        }
        

        return ee.agregarAsignaturaVigente(aa.getNombre(), id);
    }
    //realiza lo mismo del anterior solo que se le pasa por parametro el rut del estudiante 
    public boolean agregarAsignaturaVigente(String rut)throws IOException{
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
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

        return ee.agregarAsignaturaVigente(aa.getNombre(), aa.getId());
    }
    //ve si existe el estudiante y la asignatura, para luego agregarla a las asignaturas aprobadas
    public boolean agregarAsignatura(String rut, String id){
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
        Asignatura aa = buscarAsignatura(id);
        if(ee == null){
            return false;
        }
        if(aa == null){
            return false;
        }
        if(ee.agregarAsignaturaAprobada(id)){
            return ee.agregarAsignatura(aa.getNombre(), id, aa.getNota());
        }
        return false;
        
    }
    //realiza lo mismo que el anterior, solo que se le pasa el rut del estudiante
    public boolean agregarAsignatura(String rut)throws IOException{
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
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
    //busca la asignatura aprobada y modifica su nota
    public boolean modificarNota(String rut) throws IOException, NotaException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
        if (ee == null)
            return false;
        System.out.println("Conoce sus asignaturas?");
        System.out.println("Ingrese: 0 (no) || 1 (si)");
        String op = leer.readLine();
        if(op.equals("1")){
            System.out.println("Ingrese id de la Asignatura:");
            String id = leer.readLine();
            return ee.modificarNota(id);
        }
        else{
            
            return ee.modificarNota();
        }
        
        
    }
    
    public boolean eliminarAsignatura(String rut, String id){
        EstudianteVigente ee = (EstudianteVigente)buscarEstudiante(rut);
        if (ee == null)
            return false;
        
        return ee.eliminarAsignatura(id);
    }
    
    public void mostrarPorAnno(String an){
        int j = listAlumnosTotal.size();
        if(j == 0){
            System.out.println("Carrera sin alumnos :c");
            System.out.println("");
            return;
        }
        Estudiante aux;
        System.out.println("Alumnos de la generacion "+an);
        for (int i = 0; i<j; i++) {
            aux = (Estudiante)listAlumnosTotal.get(i);
            if (aux.mostrarPorAnno(an)){
                System.out.println(aux.getNombre());
            }
        }
        System.out.println("");
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
    public void esTitulado(EstudianteTitulado ee){
        int j = listAsignaturasTotal.size();
       
        Asignatura aux;
        for (int i = 0; i<j; i++) {
            aux = (Asignatura)listAsignaturasTotal.get(i);
            ee.agregarAsignatura(aux.getNombre(), aux.getId(), aux.getNota());
        }
        System.out.println("Estudiante titulado, asignaturas completadas");
    }
}
