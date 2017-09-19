package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.ConcursoBean;

public interface ConcursoDAO {

	
	public abstract int insertaConcurso(ConcursoBean obj) throws Exception;
	public abstract int actualizaConcurso(ConcursoBean obj) throws Exception;
	public abstract List<ConcursoBean> consultaConcurso(String filtro) throws Exception;
	
	
}
