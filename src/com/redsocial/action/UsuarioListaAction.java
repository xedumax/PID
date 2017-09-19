package com.redsocial.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.service.UsuarioService;
import com.redsocial.service.UsuarioServiceImpl;

@ParentPackage(value = "dawi")
public class UsuarioListaAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<UsuarioBean> data; 
	
	@Action(value="/listaUsuario",results={@Result(location="/listaUsuario.jsp",name="success")	})
	public String registra(){
		UsuarioService service = new UsuarioServiceImpl();
		try {
			data = service.lista();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<UsuarioBean> getData() {
		return data;
	}

	public void setData(List<UsuarioBean> data) {
		this.data = data;
	}
	
	
}
