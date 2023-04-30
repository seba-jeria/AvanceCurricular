package copiaavancecurricular;

public class EstudianteTitulado extends Estudiante{
    private String annoTitulacion;

    public EstudianteTitulado(String annoTitulacion, String nombreEstudiante, String annoIngreso, String rut) {
        super(nombreEstudiante, annoIngreso, rut);
        this.annoTitulacion = annoTitulacion;
    }

    public EstudianteTitulado() {
        super();
        this.annoTitulacion = super.getAnnoIngreso() + 6;
    }

    public String getAnnoTitulacion() {
        return annoTitulacion;
    }

    public void setAnnoTitulacion(String annoTitulacion) {
        this.annoTitulacion = annoTitulacion;
    }
    
    public void identificarse(){
        System.out.println("Estudiante titulado");
        System.out.println(getNombre()+" "+getRut());
        System.out.println("Ingreso: "+getAnnoIngreso()+"   Egreso: "+getAnnoTitulacion());
        System.out.println("");
    }
}
