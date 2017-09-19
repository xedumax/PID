package com.redsocial.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.redsocial.bean.UbigeoBean;
import com.redsocial.bean.UsuarioBean;

import com.redsocial.service.UsuarioServiceImpl;
import com.redsocial.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@SuppressWarnings("serial")
@ParentPackage("dawi")
@InterceptorRefs(value={@InterceptorRef("fileUpload"),	@InterceptorRef("jsonValidationWorkflowStack")})


public class UsuarioRegistroAction extends ActionSupport {

	private static long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(UsuarioRegistroAction.class);
	
	/*NUEVO  para la consulta*/
	private List<UsuarioBean> usuarios= new ArrayList<UsuarioBean>();
	
	private String filtro;
	
	
	/*NUEVO*/

	
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String sexo;
	private String status; 
	private File fotos;
	private String fecha;
	
	private String departamento;
	private String provincia;
	private String distrito;
	
	
	
	/*
	 * 1)Cuando las imágenes se envía por struts 
	 * Se recibe en un tipo de dato File
	 * 
	 * 2)La base datos no recibe File, recibe []byte
	 * 
	 * 3)Se convierte de File hacia []byte
	 * 
	 */
	
	
	
	
	
	@Action(value="/registraUsuario",results={
			@Result(name="success",location="/registraUsuario.jsp")
	})
	public String registra() throws IOException{
		log.info("En registra Usuario");
			UsuarioServiceImpl service=new UsuarioServiceImpl();
			
			UbigeoBean ubigeo=new UbigeoBean();
			ubigeo.setDepartamento(departamento);
			ubigeo.setProvincia(provincia);
			ubigeo.setDistrito(distrito);
			UbigeoBean ubigeoFinal = service.obtenerIdUbigeo(ubigeo);
			
			UsuarioBean usuario = new UsuarioBean();
			usuario.setEmail(email);
			usuario.setPassword(password);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setSexo(sexo);
			usuario.setStatus(status);
			usuario.setFotosBytes(Constantes.getBytesFromFile(fotos));
			usuario.setFecha(fecha);
			usuario.setIdUbigeo(ubigeoFinal.getIdUbigeo());
			 
			try {	
			service.registraUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	
	@Action(value="/actualizaUsuario",results={
			@Result(name="success",location="/crudUsuario.jsp")
	})
	public String actualiza() throws IOException{
		UsuarioBean usuario = new UsuarioBean();
	
		usuario.setEmail(email);
	//  usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setSexo(sexo);
	//	usuario.setStatus(status);
	//  usuario.setFotosBytes(Constantes.getBytesFromFile(fotos));
		usuario.setFecha(fecha);
		
		UsuarioServiceImpl service = new UsuarioServiceImpl();
		try {
			service.actualizaUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	@Action(value="/consultaUsuario",results={
			@Result(name="success",location="/crudUsuario.jsp")
	})
	public String consulta(){
		log.info("En consulta usuario");
	
		UsuarioServiceImpl service = new UsuarioServiceImpl();
		
		try {
			usuarios = service.consultaUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	//SET
	
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	public static void setSerialVersionUID(long serialVersionUID) {
		UsuarioRegistroAction.serialVersionUID = serialVersionUID;
	}


	@RequiredStringValidator(message="El Email es requerido")
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	public static Log getLog() {
		return log;
	}


	public static void setLog(Log log) {
		UsuarioRegistroAction.log = log;
	}


	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	


	


	@RequiredStringValidator(message="La contraseña es requerido")
	public void setPassword(String password) {
		this.password = password;
	}

	@RequiredStringValidator(message="El Nombre es requerido")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@RequiredStringValidator(message="El Apellido es requerido")
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@RequiredStringValidator(message="El Sexo es requerido")
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@RegexFieldValidator(message="La fecha es yyyy-MM-dd", regexExpression="((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])")
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	//GET
	
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


	public String getStatus() {
		return status;
	}



	public String getSexo() {
		return sexo;
	}

	


	public String getFecha() {
		return fecha;
	}
	public File getFotos() {
		return fotos;
	}
	public void setFotos(File fotos) {
		this.fotos = fotos;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
}
