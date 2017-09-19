package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.ConcursoBean;
import com.redsocial.bean.UbigeoBean;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.dao.MySqlUsuarioDAO;

public class UsuarioServiceImpl implements UsuarioService{
MySqlUsuarioDAO dao = new MySqlUsuarioDAO();

	
	public int registraUsuario(UsuarioBean bean) throws Exception {
		return dao.inserta(bean);
	}
	
	public List<UsuarioBean> lista() throws Exception {
		return dao.lista();
	}
	
	public UsuarioBean obtienePorPK(int idUsuario) throws Exception {
		return dao.obtienePorPK(idUsuario);
	}

	public int actualizaUsuario(UsuarioBean obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizaUsuario(obj);
	}

	public List<UsuarioBean> consultaUsuario(String filtro) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultaUsuario(filtro);
	}

	public UbigeoBean obtenerIdUbigeo(UbigeoBean ubigeo) {
		// TODO Auto-generated method stub
		return dao.obtenerIdUbigeo(ubigeo);
		
	}




}
