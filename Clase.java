
public class Clase {
	private String nombre;
	private int precio;
	private String empresa;
	public Clase(String nombre, int precio, String empresa) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.empresa = empresa;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public Clase() {
	
}
}
