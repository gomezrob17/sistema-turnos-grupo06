package datos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Especialidad {
	private int idEspecialidad;
	private String nombre;
	private Set<Profesional> profesionales = new HashSet<>();
	
	public Especialidad(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Especialidad() {}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	protected void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Profesional> getProfesionales() {
		return profesionales;
	}

	public void setProfesionales(Set<Profesional> profesionales) {
		this.profesionales = profesionales;
	}

	public boolean equals(Especialidad especialidad){return (idEspecialidad==especialidad.getIdEspecialidad());}
	
	public boolean agregar(Profesional profesional){	
		boolean agregar=false;
		if (! (profesionales.contains(profesional))) {
		agregar=profesionales.add(profesional);
		}
		return agregar;
	}

    public boolean eliminar(Profesional profesional){    	
    	Profesional borrar=null;  
    	boolean eliminar=false;
    	Iterator<Profesional> it = profesionales.iterator();
        while ((it.hasNext()) && (borrar==null)){
        	Profesional p=it.next();
             if (p.equals(profesional) ) borrar=p;
            }		
		eliminar=profesionales.remove(borrar);
		return eliminar;
		}
	
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombre=" + nombre + "]";
	}
	
	public String toStringConProfesionales() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Especialidad: ").append(nombre).append("\n");

	    if (profesionales != null && !profesionales.isEmpty()) {
	        sb.append("Profesionales:\n");
	        for (Profesional p : profesionales) {
	            sb.append("-Matricula: ").append(p.getMatricula()).append(" ");
	            sb.append("Nombre: ").append(p.getNombre()).append(" ");
	            sb.append("Apellido: ").append(p.getApellido()).append(" ");
	            sb.append("DNI: ").append(p.getDni()).append("\n");
	        }
	    } else {
	        sb.append("No hay profesionales asociados.\n");
	    }
	    return sb.toString();
}
	
}
