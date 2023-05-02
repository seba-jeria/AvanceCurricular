package copiaavancecurricular;

import java.util.*;


public class EstudianteVigente extends Estudiante{
    //se inicializan las variables
    private ArrayList <Asignatura> asignaturasVigentes = new ArrayList();
    private int cantAsignaturas;
    
    //se crea el constructor, al cual se le pasan los parametros 
    public EstudianteVigente(String nombreEstudiante, String annoIngreso, String rut){
        super(nombreEstudiante,  annoIngreso,  rut);
        asignaturasVigentes = new ArrayList();
        cantAsignaturas = 0;
    }
    //se crea el constructor, cual no se le entrega ningun parametro
    //ademas se ocupa super para ocupar el contructor de la clase padre
    public EstudianteVigente(){
        super();
        asignaturasVigentes = new ArrayList();
        cantAsignaturas = 0;
    }
    
    //se crean los set y get
    public int getCantAsignaturas() {
        return cantAsignaturas;
    }

    public void setCantAsignaturas(int cantAsignaturas) {
        this.cantAsignaturas = cantAsignaturas;
    }
    
    //muestra los datos del estudiante vigente
    public void identificarse(){
        System.out.println("Estudiante vigente");
        System.out.println(getNombre()+" "+getRut());
        System.out.println("Cantidad de asignaturas actuales: "+ getCantAsignaturas());
        System.out.println("");
    }
    //muestra las asignaturas vigentes
    public void mostrarVigentes(){
        int j = asignaturasVigentes.size();
        Asignatura aux;
        for(int i = 0; i<j; i++){
            aux = (Asignatura)asignaturasVigentes.get(i);
            System.out.println(aux.getNombre());
        }
    }
    //elimina las asignaturas de la lista
    public boolean eliminarAsignatura(String id){
        Asignatura aa = buscarAsignaturaVigente(id);
        if (aa == null)
            return false;
 
        asignaturasVigentes.remove(aa);
        cantAsignaturas--;
        return true;
    }
    //recorre la lista y retorna la asignatura
    public Asignatura buscarAsignaturaVigente(String id){
        int j = asignaturasVigentes.size();
        Asignatura aux;
        for(int i = 0; i<j; i++){
            aux = (Asignatura)asignaturasVigentes.get(i);
            if(id.equals(aux.getId())){
                return aux;
            }
        }
        return null;
    }
    //busca la asignatura y la elimina de la lista vigente, retornando true
    public boolean agregarAsignaturaAprobada(String id){
        if(buscarAsignaturaVigente(id) != null){
            if(eliminarAsignatura(id)){
                
                return true;
            }
            return(false);
        }
        return true;
    }
    //agrega la asignatura a la lista
    public boolean agregarAsignaturaVigente (String nombre, String id){
       
       /* retorna true si la asignatura se agregó, y false si no lo hizo*/
        if(buscarAsignaturaVigente(id) == null){
            Asignatura aa = super.buscarAsignatura(id);
            if(aa == null){
                Asignatura asig = new Asignatura(nombre, id);
                asignaturasVigentes.add(asig);
                cantAsignaturas++;
                return true;
            }
        }
        return(false);
   }
}
