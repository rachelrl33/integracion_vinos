package dominio;

public class Vino {
	private String nombre, tipo, cosecha, precio, stock;


	public Vino(String nombre, String tipo, String cosecha, String precio, String stock) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.cosecha = cosecha;
		this.precio = precio;
		this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getCosecha() {
		return cosecha;
	}


	public void setCosecha(String cosecha) {
		this.cosecha = cosecha;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}



	
}