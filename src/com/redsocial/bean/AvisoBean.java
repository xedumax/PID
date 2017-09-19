package com.redsocial.bean;

public class AvisoBean {

	private int idAviso;
	private String descripcion;
	private double precio;
	private int idPais;
	private PaisBean pais;
	
	public int getIdAviso() {
		return idAviso;
	}
	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public PaisBean getPais() {
		return pais;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public void setPais(PaisBean pais) {
		this.pais = pais;
	}
	
	
}
