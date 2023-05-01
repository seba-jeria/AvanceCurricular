package copiaavancecurricular;

import java.util.*;


public class EstudianteVigente extends Estudiante{
    private ArrayList <Asignatura> asignaturasVigentes = new ArrayList();
    private int cantAsignaturas;
    
    public EstudianteVigente(String nombreEstudiante, String annoIngreso, String rut){
        super(nombreEstudiante,  annoIngreso,  rut);
        asignaturasVigentes = new ArrayList();
        cantAsignaturas = 0;
    }
    public EstudianteVigente(){
        super();
        asignaturasVigentes = new ArrayList();
        cantAsignaturas = 0;
    }

    public int getCantAsignaturas() {
        return cantAsignaturas;
    }

    public void setCantAsignaturas(int cantAsignaturas) {
        this.cantAsignaturas = cantAsignaturas;
    }
    
    
    public void identificarse(){
        System.out.println("Estudiante vigente");
        System.out.println(getNombre()+" "+getRut());
        System.out.println("Cantidad de asignaturas actuales: "+ getCantAsignaturas());
        System.out.println("");
    }
    public void mostrarVigentes(){
        int j = asignaturasVigentes.size();
        Asignatura aux;
        for(int i = 0; i<j; i++){
            aux = (Asignatura)asignaturasVigentes.get(i);
            System.out.println(aux.getNombre());
        }
    }
    
    public boolean eliminarAsignatura(String id){
        Asignatura aa = buscarAsignaturaVigente(id);
        if (aa == null)
            return false;
 
        asignaturasVigentes.remove(aa);
        cantAsignaturas--;
        return true;
    }
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
    public boolean agregarAsignaturaAprobada(String id){
        if(buscarAsignaturaVigente(id) != null){
            if(eliminarAsignatura(id)){
                
                return true;
            }
            return(false);
        }
        return true;
    }
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
