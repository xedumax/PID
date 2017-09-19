package com.redsocial.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.service.UsuarioService;
import com.redsocial.service.UsuarioServiceImpl;

@SuppressWarnings("serial")
@ParentPackage(value = "dawi")
public class UsuarioImagenAction extends ActionSupport {

	private InputStream imagenFoto;
	private int idCodigo;
	
	//type="stream" --> Se envia un trama de bytes
	//"inputName","imagenData" -->El objeto que tiene la trama de bytes

	@Action(value = "/verFoto", 
			results = { @Result(
							params={"inputName","imagenFoto"}, 
							name = "success", type="stream") })
	public String verFoto() throws Exception {
		try {
			
			UsuarioService service = new UsuarioServiceImpl();
			UsuarioBean bean = service.obtienePorPK(idCodigo);			
			imagenFoto = new ByteArrayInputStream(bean.getFotosBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public InputStream getImagenFoto() {
		return imagenFoto;
	}

	public void setImagenFoto(InputStream imagenFoto) {
		this.imagenFoto = imagenFoto;
	}

	public int getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}
	
	
}
