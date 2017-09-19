package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.ConcursoBean;
import com.redsocial.dao.MySqlConcursoDAO;

public class ConcursoServiceImpl implements ConcursoService {

	MySqlConcursoDAO dao = new MySqlConcursoDAO();
	
	
	public int insertaConcurso(ConcursoBean obj) throws Exception {
		return dao.insertaConcurso(obj);
	}

	
	public int actualizaConcurso(ConcursoBean obj) throws Exception {
		return dao.actualizaConcurso(obj);
	}

	
	public List<ConcursoBean> consultaConcurso(String filtro) throws Exception {
		return dao.consultaConcurso(filtro);
	}

}
