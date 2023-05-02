/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package copiaavancecurricular;

/**
 *
 * @author seba
 */

// se importan los paquetes
import java.io.*;
import java.io.FileWriter;


public class CopiaAvanceCurricular {
    //se crea una vairable de instacia
    static Carrera miCarrera;

    public static void main(String[] args) throws IOException, RutException, NotaException {
        int opcion;
        boolean salir = true;
        //se inicializa nuestra carrera
        miCarrera = new Carrera(); 
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("**************************************************");
        System.out.println("BIENVENIDO");
        System.out.println("**************************************************");
        
        //llamado de funciones para leer los csvs
        leerAlumno();
        leerAsignatura();
        
        while(salir){
            //menu
            System.out.println("1. Añadir estudiante manualmente al sistema");
            System.out.println("2. Añadir una asignatura manualmente al sistema");
            System.out.println("3. Ingresar asignatura aprobada a un estudiante");
            System.out.println("4. Ingresar asignatura vigente a un estudiante");
            System.out.println("5. Modificar nota de una asignatura aprobada");
            System.out.println("6. Eliminar asignatura vigente");
            System.out.println("7. Mostrar todos los estudiantes");
            System.out.println("8. Mostrar todas las asignaturas");
            System.out.println("9. Mostrar todos las asignaturas vigentes de un estudiante");
            System.out.print("10. Mostrar informacion del estudiante");
            System.out.println(" ( coleccion de asignaturas aprobadas )");
            System.out.println("11. Mostrar alumnos por nota mayor o igual");
            System.out.println("12. Mostrar alumnos de una generacion (anno ingreso)");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = Integer.parseInt(leer.readLine());
            
            switch (opcion) {
                case 1:{
                    System.out.println("_________________________________________________");
                    ingresarEstudiante();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 2:{
                    System.out.println("_________________________________________________");
                    annadirRamo();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 3:{
                   System.out.println("_________________________________________________");
                   agregarAsignatura();
                   System.out.println("_________________________________________________");
                   break;
                } 
                case 4:{
                    System.out.println("_________________________________________________");
                    agregarAsignaturaVigente();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 5:{
                    System.out.println("_________________________________________________");
                    modificarNota();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 6:{
                    System.out.println("_________________________________________________");
                    eliminarAsignatura();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 7:{
                    System.out.println("_________________________________________________");
                    mostrarEstudiantes();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 8:{
                    System.out.println("_________________________________________________");
                    mostrarAsignaturas();
                    System.out.println("_________________________________________________");
                    break; 
                }
                case 9:{
                    System.out.println("_________________________________________________");
                    mostrarVigentes();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 10:{
                    System.out.println("_________________________________________________");
                    mostrarDatosEstudiante();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 11:{
                    System.out.println("_________________________________________________");
                    mostarPorNotaMin();
                    System.out.println("_________________________________________________");
                    break;
                }
                case 12:{
                    System.out.println("_________________________________________________");
                    mostrarPorAnno();
                    System.out.println("_________________________________________________");
                    break;
                }
                    
                case 0:{
                    System.out.println("\nPrograma finalizado...");
                    salir = false;
                    break;
                }
                
                default:{
                    
                    System.out.println("Instruccion incorrecta\n");
                    System.out.println("Para volver ingrese cualquier caracter");
                    String aux;
                    aux = leer.readLine();
                    System.out.println("");
                    break;
                }
            }
        }
    }
    
    //funcion que lee los alumnos de un csv y los carga en un mapa
    public static  void leerAlumno() throws RutException{
        String ruta = "alumnos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                EstudianteVigente estudiante = new EstudianteVigente();
                int i = 0; 

                for (String dato : datos) {
                   i++;

                   switch(i){
                    case 1:{
                        estudiante.setRut(dato);
                    }
                    case 2:{
                        estudiante.setNombre(dato);
                    }
                    case 3:{
                        estudiante.setAnnoIngreso(dato);
                    }
                   }
                }
                //System.out.println(); // salto de línea para la siguiente fila
                miCarrera.agregarEstudiante(estudiante);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    //funcion que lee las asignaturas de un csv y los carga en un mapa
    public static  void leerAsignatura() {
        String ruta = "asignaturas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
               String[] datos = linea.split(",");
               Asignatura asignatura = new Asignatura();
               int i = 0;
               
               for (String dato : datos) {
                  i++;
                  
                  switch(i){
                      case 1:{
                          asignatura.setNombre(dato);
                      }
                      case 2:{
                          asignatura.setId(dato);
                      }
                  }
               }
               //System.out.println(); // salto de linea para la siguiente fila
               miCarrera.annadirRamo(asignatura);
           }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    //Ingresa manualmente las asignaturas a un mapa y los guarda en un csv
    public static void annadirRamo() throws IOException{
        BufferedReader hh = new BufferedReader(new InputStreamReader(System.in));
        String ruta = "asignaturas.csv";
        try (FileWriter fw = new FileWriter(ruta, true)){
            System.out.println("Ingrese nombre asignatura: ");
            String nombreA = hh.readLine();
            System.out.println("Ingrese id: ");
            String id = hh.readLine();
            int nota = 1;
            Asignatura asignatura = new Asignatura(nombreA, id, nota);
            if(miCarrera.annadirRamo(asignatura)){
                fw.append("\n"); // salto de línea para agregar los datos en una nueva línea
                fw.append(nombreA).append(",");
                fw.append(id);
                System.out.println("Asignatura ingresada al sistema :)");
            }
            else{
                System.out.println("Error. No se ha ingresado la asignatura");
            }
                
        }catch (IOException e) {
         System.out.println("Error");
      }
    }
    
    
    //Ingresa manualmente los alumnos a un mapa y los guarda en un csv especifico
    public static void ingresarEstudiante() throws IOException, RutException{
        BufferedReader hh = new BufferedReader(new InputStreamReader(System.in));
        String ruta = "alumnos.csv";
        try (FileWriter fw = new FileWriter(ruta, true)){
            System.out.println("Ingrese rut: ");
            String rut = hh.readLine();
            System.out.println("Ingrese nombre: ");
            String nombreE = hh.readLine();
            System.out.println("Ingrese año de ingreso: ");
            String año = hh.readLine();
            System.out.println("Ingrese si es estudiante vigente o titulado ");
            System.out.println("0 (vigente) || 1 (titulado)");
            String op = hh.readLine();
            if(op.equals("0")){
                EstudianteVigente estudiante = new EstudianteVigente(nombreE, año, rut);
                if(miCarrera.agregarEstudiante(estudiante)){
                    fw.append("\n"); // salto de línea para agregar los datos en una nueva línea
                    fw.append(rut).append(",");
                    fw.append(nombreE).append(",");
                    fw.append(año);
                
                    System.out.println("Estudiante ingresado al sistema :)");
                }
                else{
                   System.out.println("Error. No se ha ingresado el alumno al sistema.");
                }    
            }
            else{
                System.out.println("Ingrese año de titulacion: ");
                String att = hh.readLine();
                EstudianteTitulado estudiante = new EstudianteTitulado(att, nombreE, año, rut);
                if(miCarrera.agregarEstudiante(estudiante)){
                    fw.append("\n"); // salto de línea para agregar los datos en una nueva línea
                    fw.append(rut).append(",");
                    fw.append(nombreE).append(",");
                    fw.append(año);
                    miCarrera.esTitulado(estudiante);
                    System.out.println("Estudiante ingresado al sistema :)");
                }
                else{
                   System.out.println("Error. No se ha ingresado el alumno al sistema.");
                }    
            }
        
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }
    // referidas al estudiante en sí
    //Asigna una asignatura aprobada a un estudiante mediante la clave de esta
    public static void agregarAsignaturaVigente() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Funcion de agregar una asignatura vigente");
             
        System.out.print("Ingrese rut (x para salir): ");
        String rut = leer.readLine();
        if(rut.equals("x")){
            System.out.println("Ha salido de la funcion\n");
            return;
        }
        
        System.out.println("¿Conoce las asignaturas que hay en el sistema?");
        System.out.println("Ingrese: 0 (NO) || 1 (SI)  ");
        String op = leer.readLine();
        if(op.equals("0")){
            if(miCarrera.agregarAsignaturaVigente(rut)){
                System.out.println("Asignatura vigente agregada con exito!\n");
                return;
            }   
        }
        
        if(op.equals("1")){
            System.out.println("Ingrese ID de la asignatura vigente(x para salir): ");
            String id = leer.readLine();
            System.out.println("");
            if(id.equals("x")){
                System.out.println("Ha salido de la funcion\n");
                return;
            }
            if(miCarrera.agregarAsignaturaVigente(rut, id)){
                System.out.println("Asignatura vigente agregada con exito!\n");
                return;
            }
        }
        
        System.out.println("No se ha agregado la asignatura aprobada al estudiante");
        System.out.println("");       
    }
    
    //agrega una asignatura aprobada al estudiante
    public static void agregarAsignatura() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Funcion de agregar una asignatura aprobada por el estudiante");
             
        System.out.print("Ingrese rut (x para salir): ");
        String rut = leer.readLine();
        if(rut.equals("x")){
            System.out.println("Ha salido de la funcion\n");
            return;
        }
        
        System.out.println("¿Conoce las asignaturas que hay en el sistema?");
        System.out.println("Ingrese: 0 (NO) || 1 (SI)  ");
        String op = leer.readLine();
        if(op.equals("0")){
            if(miCarrera.agregarAsignatura(rut)){
                System.out.println("Asignatura aprobada agregada con exito!\n");
                return;
            }   
        }
        
        if(op.equals("1")){
            System.out.println("Ingrese ID de la asignatura aprobada(x para salir): ");
            String id = leer.readLine();
            System.out.println("");
            if(id.equals("x")){
                System.out.println("Ha salido de la funcion\n");
                return;
            }
            if(miCarrera.agregarAsignatura(rut, id)){
                System.out.println("Asignatura aprobada agregada con exito!\n");
                return;
            }
        }
        
        System.out.println("No se ha agregado la asignatura aprobada al estudiante");
        System.out.println("");       
    }
    //Muestra los datos del estudiante y las asignaturas aprobadas
    public static void mostrarDatosEstudiante()throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Funcion mostrar info del estudiante\n");
        System.out.print("Ingrese el rut (x para salir): ");
        String rut = leer.readLine();
        System.out.println("");
        if(rut.equals("x")){
            System.out.println("Ha salido de la funcion\n");
            return;
        }
        Estudiante ee = (Estudiante)miCarrera.buscarEstudiante(rut);
        
        if(ee == null){
            System.out.println("Alumno no encontrado");
            return;
        }

        System.out.println("Nombre: "+ee.getNombre());
        System.out.println("Año ingreso: "+ee.getAnnoIngreso());
        System.out.println("Rut: "+ee.getRut()+"\n");
        ee.mostrarAprobadas();
        
                    
        System.out.println("");
    }

    //muestra todas las asignaturas vigentes de un estudiante vigente
    public static void mostrarVigentes() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Funcion mostrar info del estudiante\n");
        System.out.print("Ingrese el rut (x para salir): ");
        String rut = leer.readLine();
        System.out.println("");
        if(rut.equals("x")){
            System.out.println("Ha salido de la funcion\n");
            return;
        }
        EstudianteVigente ee = (EstudianteVigente)miCarrera.buscarEstudiante(rut);
        ee.mostrarVigentes();
        System.out.println("");
    }
   
    // son necesarias¿
    public static void mostrarEstudiantes(){
        miCarrera.listarEstudiantes();
        System.out.println("");
    }
    public static void mostrarAsignaturas(){
        miCarrera.mostrarRamos();
        System.out.println("");
    }
    public static void modificarNota() throws IOException, NotaException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese rut del Estudiante:");
        String rut = leer.readLine();
        
        if(miCarrera.modificarNota(rut)){
            System.out.println("Modificada con exito");
        }
    }
    
    //elimina una asignatura vigente
    public static void eliminarAsignatura() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese rut del Estudiante:");
        String rut = leer.readLine();
        System.out.println("Ingrese id de la Asignatura:");
        String id = leer.readLine();
        miCarrera.eliminarAsignatura(rut, id);
    }
    
    //muestra todos los estudiantes del año ingresado
    public static void mostrarPorAnno() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese anno de ingreso: ");
        String an = leer.readLine();
        miCarrera.mostrarPorAnno(an);
    }
    
    
    //muestra todos los estudiantes con nota mayor o igual a la ingresada en una asignatura especifica
    public static void mostarPorNotaMin() throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese id de la Asignatura:");
        String id = leer.readLine();
        System.out.println("Ingrese nota minima:");
        int nota = Integer.parseInt(leer.readLine());
        miCarrera.mostarPorNotaMin(nota, id);
    }
}
