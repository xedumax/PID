package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.ConcursoBean;

public class MySqlConcursoDAO implements ConcursoDAO {

	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public int insertaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaConcurso", obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
		return salida;
	}

	public int actualizaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaConcurso", obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
		return salida;
	}

	@SuppressWarnings("unchecked")

	public List<ConcursoBean> consultaConcurso(String filtro) throws Exception {
		List<ConcursoBean> salida = new ArrayList<ConcursoBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = (List<ConcursoBean>) session.selectList("SQL_consultaConcurso", filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return salida;
	}

}
