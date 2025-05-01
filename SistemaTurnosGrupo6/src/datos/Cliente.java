package datos;

import java.time.LocalDate;

public class Cliente extends Persona {

	private LocalDate fechaAlta;
    private boolean activo;
    //private Contacto contacto;
	
    public Cliente() {
	}

	public Cliente(int dni, String nombre, String apellido, LocalDate fechaAlta, boolean activo /*,Contacto contacto*/) {
		super(dni,nombre,apellido);
		this.fechaAlta = fechaAlta;
		this.activo = activo;
		//this.contacto = contacto;
	}

	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	/*
	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}*/

	@Override
	public String toString() {
		return "Cliente ["+ super.toString()+", fechaAlta=" + fechaAlta + ", activo=" + activo + "]";
	}

	//para cuando la clase contacto sea creada
//	@Override
//	public String toString() {
//		return "Cliente ["+ super.toString()+", fechaAlta=" + fechaAlta + ", activo=" + activo + ", contacto=" + contacto + "]";
//	}
    
	
}
