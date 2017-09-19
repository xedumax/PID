package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.AvisoBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.PaisBean;

public interface AvisoDAO {

	public abstract List<AvisoBean> listaAviso() throws Exception;
	public abstract List<PaisBean> listaPais() throws Exception;
	public int registraAviso(AvisoBean obj) throws Exception;
	
	//Consulta
	public abstract List<FiltroBean> consultaAviso(FiltroBean filtro) throws Exception;
	
	//Eliminar
	public int eliminaAviso(int idAviso) throws Exception;
}
