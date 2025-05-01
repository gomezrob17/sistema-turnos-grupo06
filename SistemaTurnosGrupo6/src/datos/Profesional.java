package datos;

public class Profesional extends Persona {

	private String matricula;
    private double sueldo;
    private boolean activo;
    //private Especialidad especialidad;
	
    
    public Profesional() {
		super();
	}


	public Profesional(int dni, String nombre, String apellido,String matricula, double sueldo, boolean activo/*,Especialidad especialidad*/) {
		super(dni,nombre,apellido);
		this.matricula = matricula;
		this.sueldo = sueldo;
		this.activo = activo;
		//this.especialidad = especialidad;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
/*
	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}*/


	@Override
	public String toString() {
		return "Profesional [" + super.toString()+ ",matricula=" + matricula + ", sueldo=" + sueldo + ", activo=" + activo + "]";
	}
	
	//para cuando la clase especialidad sea creada
//	@Override
//	public String toString() {
//		return "Profesional [" + super.toString()+ ",matricula=" + matricula + ", sueldo=" + sueldo + ", activo=" + activo + ", especialidad=" + especialidad + "]";
//	}
	
	
}
