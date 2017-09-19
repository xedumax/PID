package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.AvisoBean;
import com.redsocial.bean.FiltroBean;
import com.redsocial.bean.PaisBean;

public class MySqlAvisoDAO implements AvisoDAO {

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
	
	
	@SuppressWarnings("unchecked")

	public List<AvisoBean> listaAviso() throws Exception {
		List<AvisoBean>  data = new ArrayList<AvisoBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			data = session.selectList("SQL_listaAviso");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	
	public List<PaisBean> listaPais() throws Exception {
		List<PaisBean>  data = new ArrayList<PaisBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			data = session.selectList("SQL_listaPais");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return data;
	}

	
	public int registraAviso(AvisoBean obj) throws Exception {
		int insertados =-1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			insertados = session.insert("SQL_insertaAviso", obj);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return insertados;
	}

	@SuppressWarnings("unchecked")

	public List<FiltroBean> consultaAviso(FiltroBean filtro) throws Exception {
		List<FiltroBean>  data = new ArrayList<FiltroBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			data = session.selectList("SQL_consultaAviso",filtro );
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return data;
	}

	public int eliminaAviso(int idAviso) throws Exception {
		int eliminados =-1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			eliminados = session.delete("SQL_eliminaAviso", idAviso);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return eliminados;
	}

	
}
