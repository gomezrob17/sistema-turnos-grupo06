package datos;

public class Contacto {

	private int idContacto;
	private String email;
	private String telefono;
	private Cliente cliente;
	
	public Contacto(String email, String telefono) {
		super();
		this.email = email;
		this.telefono = telefono;
	}
	
	public Contacto(){}
	
	public int getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", telefono=" + telefono + ", cliente=" + cliente.toString()
				+ "]";
	}
	
	public String toStringSinCliente() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", telefono=" + telefono + "]";
	}
}
