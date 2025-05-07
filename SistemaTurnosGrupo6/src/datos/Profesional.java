package datos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Profesional extends Persona {

	private String matricula;
    private double sueldo;
    private boolean activo;
	private Set<Especialidad> especialidades = new HashSet<>();
    //private Especialidad especialidad;
	
    
    public Profesional() {
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
	
	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	
/*	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}*/


	@Override
	public String toString() {
		return "Profesional [" + super.toString()+ ",matricula=" + matricula + ", sueldo=" + sueldo + ", activo=" + activo + "]";
	}


	public boolean equals(Profesional profesional){return (idPersona==profesional.getIdPersona());}
	
	public boolean agregar(Especialidad especialidad){	
		boolean agregar=false;
		if (! (especialidades.contains(especialidad))) {
		agregar=especialidades.add(especialidad);
		}
		return agregar;
	}

    public boolean eliminar(Especialidad especialidad){    	
    	Especialidad borrar=null;  
    	boolean eliminar=false;
    	Iterator<Especialidad> it = especialidades.iterator();
        while ((it.hasNext()) && (borrar==null)){
        	Especialidad e=it.next();
             if (e.equals(especialidad) ) borrar=e;
            }		
		eliminar=especialidades.remove(borrar);
		return eliminar;
		}
	
	
	//para cuando la clase especialidad sea creada
//	@Override
//	public String toString() {
//		return "Profesional [" + super.toString()+ ",matricula=" + matricula + ", sueldo=" + sueldo + ", activo=" + activo + ", especialidad=" + especialidad + "]";
//	}
	
	
}
