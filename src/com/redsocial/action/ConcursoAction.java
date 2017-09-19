package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.ConcursoBean;
import com.redsocial.service.ConcursoServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ConcursoAction extends ActionSupport{
	
	private static final Log log = LogFactory.getLog(ConcursoAction.class);

	//Para la consulta
	private List<ConcursoBean> concursos= new ArrayList<ConcursoBean>();
	private String filtro;
	
	//para el registrar y actualizar
	private String id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String estado;
	
	@Action(value="/registraConcurso",results={
			@Result(name="success",location="/crudConcurso.jsp")
	})
	public String registra(){
		ConcursoBean obj = new ConcursoBean();
		obj.setNombre(nombre);
		obj.setFechaInicio(fechaInicio);
		obj.setFechaFin(fechaFin);
		obj.setEstado(estado);
		
		ConcursoServiceImpl service = new ConcursoServiceImpl();
		try {
			service.insertaConcurso(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="/actualizaConcurso",results={
			@Result(name="success",location="/crudConcurso.jsp")
	})
	public String actualiza(){
		ConcursoBean obj = new ConcursoBean();
		obj.setIdConcurso(Integer.parseInt(id));
		obj.setNombre(nombre);
		obj.setFechaInicio(fechaInicio);
		obj.setFechaFin(fechaFin);
		obj.setEstado(estado);
		
		ConcursoServiceImpl service = new ConcursoServiceImpl();
		try {
			service.actualizaConcurso(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	@Action(value="/consultaConcurso",results={
			@Result(name="success",location="/crudConcurso.jsp")
	})
	public String consulta(){
		log.info("En consulta concurso");
	
		ConcursoServiceImpl service = new ConcursoServiceImpl();
		
		try {
			concursos = service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	

	public List<ConcursoBean> getConcursos() {
		return concursos;
	}


	public void setConcursos(List<ConcursoBean> concursos) {
		this.concursos = concursos;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}



