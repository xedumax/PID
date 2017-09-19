package com.redsocial.bean;

import java.io.File;

public class UsuarioBean {
	
	private int idUsuario;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String sexo;
	private String status;
	private String fecha;
	//por cada atributo
	private File fotos;
	private String fotosFileName;
	private String fotosContentType;
	private byte[] fotosBytes;
	
	private int idUbigeo;
	private UbigeoBean ubigeo;
	
	
	
	
	
	
	

	public int getIdUbigeo() {
		return idUbigeo;
	}

	public UbigeoBean getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(UbigeoBean ubigeo) {
		this.ubigeo = ubigeo;
	}

	public void setIdUbigeo(int idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public String getStatus() {
		return status;
	}
	public String getFecha() {
		return fecha;
	}
	public File getFotos() {
		return fotos;
	}
	public String getFotosFileName() {
		return fotosFileName;
	}
	public String getFotosContentType() {
		return fotosContentType;
	}
	public byte[] getFotosBytes() {
		return fotosBytes;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setFotos(File fotos) {
		this.fotos = fotos;
	}
	public void setFotosFileName(String fotosFileName) {
		this.fotosFileName = fotosFileName;
	}
	public void setFotosContentType(String fotosContentType) {
		this.fotosContentType = fotosContentType;
	}
	public void setFotosBytes(byte[] fotosBytes) {
		this.fotosBytes = fotosBytes;
	}
	
	
	
	
	
}
