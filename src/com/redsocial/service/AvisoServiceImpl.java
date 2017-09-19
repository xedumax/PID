package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.AvisoBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.PaisBean;
import com.redsocial.dao.MySqlAvisoDAO;

public class AvisoServiceImpl implements AvisoService {

	MySqlAvisoDAO dao = new MySqlAvisoDAO();
	
	
	public List<AvisoBean> listaAviso() throws Exception {
		return dao.listaAviso();
	}

	
	public List<PaisBean> listaPais() throws Exception {
		return dao.listaPais();
	}

	
	public int registraAviso(AvisoBean obj) throws Exception {
		return dao.registraAviso(obj);
	}

	
	public List<FiltroBean> consultaAviso(FiltroBean filtro) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultaAviso(filtro);
	}

	
	public int eliminaAviso(int idAviso) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminaAviso(idAviso);
	}

}
