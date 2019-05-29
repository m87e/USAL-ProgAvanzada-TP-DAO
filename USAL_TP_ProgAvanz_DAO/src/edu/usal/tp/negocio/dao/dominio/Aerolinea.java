package edu.usal.tp.negocio.dao.dominio;

public class Aerolinea {

	private String nombre;
	private String[] alianza; // pasarlo a lista
	private Vuelos[] vuelo; // pasarlo a lista
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getAlianza() {
		return alianza;
	}
	public void setAlianza(String[] alianza) {
		this.alianza = alianza;
	}
	public Vuelos[] getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelos[] vuelo) {
		this.vuelo = vuelo;
	}
	public Aerolinea() {
	
		// TODO Auto-generated constructor stub
	}
	public Aerolinea(String nombre, String[] alianza, Vuelos[] vuelo) {
	
		this.nombre = nombre;
		this.alianza = alianza;
		this.vuelo = vuelo;
	}

	
	
}
