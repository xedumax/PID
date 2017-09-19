package com.redsocial.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.AvisoBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.PaisBean;
import com.redsocial.service.AvisoServiceImpl;


@SuppressWarnings("serial")
@ParentPackage(value = "dawi")
public class AvisoAction extends ActionSupport{

	private static final Log log = LogFactory.getLog(AvisoAction.class);

	private String descripcion;
	private String precio;
	private String pais;
	
	private List<PaisBean> lstPais;
	private List<AvisoBean> lstAviso;
	
	//Para la consulta
	private String fnombre;
	private String fpais;
	private List<FiltroBean> lstConsulta;
	private String id;
	
	//Action eliminar
	@Action(value="/eliminaAviso",results={@Result(location="/consultaAviso.jsp",name="success")	})
	public String elimina(){
		log.info("En elimina aviso");

		AvisoServiceImpl service =new AvisoServiceImpl();
		try {
			service.eliminaAviso(Integer.parseInt(id));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//Action consulta Aviso
	@Action(value="/consultaAviso",results={@Result(location="/consultaAviso.jsp",name="success")	})
	public String consultaAviso(){
		log.info("En listaAviso");
		AvisoServiceImpl service =new AvisoServiceImpl();
		try {
			FiltroBean obj=new FiltroBean();
			obj.setNombre(fnombre+"%");
			obj.setPais(fpais);
			
			lstConsulta =  service.consultaAviso(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	@Action(value="/registraAviso",results={@Result(location="/registraAviso.jsp",name="success")	})
	public String registra(){
		log.info("En registra aviso");

		AvisoBean objAviso = new AvisoBean();
		objAviso.setDescripcion(descripcion);
		objAviso.setPrecio(Double.parseDouble(precio));
		objAviso.setIdPais(Integer.parseInt(pais));

		AvisoServiceImpl service =new AvisoServiceImpl();
		try {
			service.registraAviso(objAviso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="/listaAviso",results={@Result(location="/listaAviso.jsp",name="success")	})
	public String listaAviso(){
		log.info("En listaAviso");
		AvisoServiceImpl service =new AvisoServiceImpl();
		try {
			lstAviso =  service.listaAviso();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="/listaPais",results={@Result(type="json",name="success")	})
	public String listaPais(){
		log.info("En listaPais");
		AvisoServiceImpl service =new AvisoServiceImpl();
		try {
			lstPais =  service.listaPais();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<PaisBean> getLstPais() {
		return lstPais;
	}

	public void setLstPais(List<PaisBean> lstPais) {
		this.lstPais = lstPais;
	}

	public List<AvisoBean> getLstAviso() {
		return lstAviso;
	}

	public void setLstAviso(List<AvisoBean> lstAviso) {
		this.lstAviso = lstAviso;
	}
	
	public String getFnombre() {
		return fnombre;
	}

	public void setFnombre(String fnombre) {
		this.fnombre = fnombre;
	}

	public String getFpais() {
		return fpais;
	}

	public void setFpais(String fpais) {
		this.fpais = fpais;
	}
	
	public List<FiltroBean> getLstConsulta() {
		return lstConsulta;
	}

	public void setLstConsulta(List<FiltroBean> lstConsulta) {
		this.lstConsulta = lstConsulta;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
