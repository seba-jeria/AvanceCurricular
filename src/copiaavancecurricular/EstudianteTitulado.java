package copiaavancecurricular;

public class EstudianteTitulado extends Estudiante{
    //se inicializan las variables 
    private String annoTitulacion;
    //se crea el contructor, al cual se le pasan los parametros
    public EstudianteTitulado(String annoTitulacion, String nombreEstudiante, String annoIngreso, String rut) {
        super(nombreEstudiante, annoIngreso, rut);
        this.annoTitulacion = annoTitulacion;
    }
    //se crea el constructor, al cual no se le ´pasa ningun parametro 
    //ademas se ocupa super para ocupar el contructor de la clase padre
    public EstudianteTitulado() {
        super();
        this.annoTitulacion = super.getAnnoIngreso() + 6;
    }
    
    //se crean los set y get
    public String getAnnoTitulacion() {
        return annoTitulacion;
    }

    public void setAnnoTitulacion(String annoTitulacion) {
        this.annoTitulacion = annoTitulacion;
    }
    //muestra los datos del estudiante
    public void identificarse(){
        System.out.println("Estudiante titulado");
        System.out.println(getNombre()+" "+getRut());
        System.out.println("Ingreso: "+getAnnoIngreso()+"   Egreso: "+getAnnoTitulacion());
        System.out.println("");
    }
}
