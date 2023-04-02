/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package copiaavancecurricular;

/**
 *
 * @author seba
 */

import java.io.*;
import java.util.*;
import java.io.FileWriter;


public class AvanceCurricular {
    
    private HashMap <String,Estudiante> mapaEstudiante = new HashMap();
    private HashMap <String,Asignatura> mapaAsignatura = new HashMap();
    BufferedReader hh = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int opcion;
        boolean salir = true;
        AvanceCurricular ac = new AvanceCurricular(); 
        csv leercsv = new csv();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        while(salir){
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Ingresar una asignatura");
            System.out.println("3. Ingresar asignaturas a un estudiante");
            System.out.println("4. Mostrar datos del estudiante");
            System.out.println("5. Mostrar todos los estudiantes ");
            System.out.println("6. Mostrar todas las asignaturas ");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = Integer.parseInt(leer.readLine());
            switch (opcion) {
                case 1:{
                    ac.ingresarEstudiante();
                    break;
                }
                case 2:{
                    ac.ingresarAsignatura();
                    break;
                }
                case 3:{
                   ac.agregarAsignaturaEstudiante();
                   break;
                } 
                case 4:{
                    ac.mostrarDatosEstudiante();
                    break;
                }
                case 5:{
                    leercsv.leerAlumno();
                    break;
                }
                case 6:{
                    leercsv.leerAsignatura();
                    break;
                }
                case 0:{
                    System.out.println("Programa finalizado.");
                    salir = false;
                    break;
                }
            }
        }
    }
    public void ingresarEstudiante() throws IOException{
        String ruta = "alumnos.csv";
        try (FileWriter fw = new FileWriter(ruta, true)){
            System.out.println("Ingrese rut: ");
            String rut = hh.readLine();
            System.out.println("Ingrese nombre: ");
            String nombreE = hh.readLine();
            System.out.println("Ingrese año de ingreso: ");
            String año = hh.readLine();
            Estudiante estudiante = new Estudiante(nombreE, año, rut);
            mapaEstudiante.put(rut, estudiante);
            fw.append("\n"); // salto de línea para agregar los datos en una nueva línea
            fw.append(rut).append(",");
            fw.append(nombreE).append(",");
            fw.append(año);
        }catch (IOException e) {
         System.out.println("Error");
      }
    }
    
    public void ingresarAsignatura() throws IOException{
        String ruta = "asignaturas.csv";
        try (FileWriter fw = new FileWriter(ruta, true)){
            System.out.println("Ingrese nombre asignatura: ");
            String nombreA = hh.readLine();
            System.out.println("Ingrese id: ");
            String id = hh.readLine();
            Asignatura asignatura = new Asignatura(nombreA, id);
            mapaAsignatura.put(id, asignatura);
            fw.append("\n"); // salto de línea para agregar los datos en una nueva línea
            fw.append(nombreA).append(",");
            fw.append(id);
        }catch (IOException e) {
         System.out.println("Error");
      }
    }
    
    public void agregarAsignaturaEstudiante() throws IOException{
        System.out.println("Ingrese rut: ");
        String rut = hh.readLine();
        
        Estudiante estudiante = mapaEstudiante.get(rut);
        
        if(estudiante != null){
            
            System.out.println("Ingrese id de la Asignatura: ");
            String id = hh.readLine();
            
            Asignatura asignatura = mapaAsignatura.get(id);
            
            if (asignatura != null){
                
                estudiante.agregarAsignaturas(asignatura.getNombreAsignatura(), asignatura.getIdAsignatura());
            }
            else{
                System.out.println("Asignatura no encontrada");
            }
        }
        else{
            System.out.println("Estudiante no encontrado");
        }
    }
    public void mostrarDatosEstudiante() throws IOException{
        
        System.out.println("Ingrese rut del Estudiante: ");
        String rut = hh.readLine();
        
        Estudiante estudiante = mapaEstudiante.get(rut);
        
        if(estudiante != null){
            System.out.println("Estudiante: "+ estudiante.getNombreEstudiante()
                                +". Rut: "+estudiante.getRut());
            System.out.println("Sus asignaturas son: ");
            ArrayList <Asignatura> aa = estudiante.getAsignaturasAprobadas();
                 
            Asignatura asignatura;
            int aux = aa.size();
            for (int i = 0; i < aux; i++){
                
                asignatura = aa.get(i);
                System.out.println("Asignatura: "+asignatura.getNombreAsignatura()+
                                   "| Id: "+asignatura.getIdAsignatura());
            }
        }
        else{
            System.out.println("Estudiante no encontrado");
        }
    }
}