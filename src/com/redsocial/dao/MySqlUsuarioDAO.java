package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.AvisoBean;
import com.redsocial.bean.ConcursoBean;
import com.redsocial.bean.UbigeoBean;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.util.ConectaDB;

public class MySqlUsuarioDAO implements UsuarioDAO {

	//Permite la crear sesiones (conexiones) en myIbatis
	//MyIbatis es un framework en la capa de datos
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
	
	public int inserta(UsuarioBean bean) throws Exception {
		int insertados =-1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			insertados = session.insert("SQL_insertaUsuario", bean);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return insertados;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<UsuarioBean> lista() throws Exception {
		SqlSession session = null;
		List lista  = null;
		try {
			session = sqlMapper.openSession();
			lista = session.selectList("SQL_listaUsuario");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}


	public UsuarioBean obtienePorPK(int idUsuario) throws Exception {
		SqlSession session = null;
		UsuarioBean bean  = null;
		try {
			session = sqlMapper.openSession();
			bean = (UsuarioBean)session.selectOne("SQL_usuarioPorPK", idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return bean;
	}
	
	public int actualizaUsuario(UsuarioBean obj) throws Exception {
		int insertados =-1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			insertados = session.insert("SQL_actualizaUsuario", obj);
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
	public List<UsuarioBean> consultaUsuario(String filtro) throws Exception {
		List<UsuarioBean>  data = new ArrayList<UsuarioBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			data = session.selectList("SQL_consultaUsuario",filtro);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}
		return data;
	}
	
	
	


	public UbigeoBean obtenerIdUbigeo(UbigeoBean ubigeo) {
		SqlSession session = null;
		UbigeoBean bean  = null;
		try {
			session = sqlMapper.openSession();
			bean = (UbigeoBean) session.selectOne("SQL_obtenerIdUbigeo",ubigeo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return bean;
	}

}
