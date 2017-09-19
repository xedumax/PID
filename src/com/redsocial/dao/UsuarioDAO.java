package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.ConcursoBean;
import com.redsocial.bean.UbigeoBean;
import com.redsocial.bean.UsuarioBean;

public interface UsuarioDAO {
	public abstract int inserta(UsuarioBean bean) throws Exception;
	public abstract List<UsuarioBean> lista() throws Exception;
	public UsuarioBean obtienePorPK(int idUsuario) throws Exception;
	
	public abstract int actualizaUsuario(UsuarioBean obj) throws Exception;
	public abstract List<UsuarioBean> consultaUsuario(String filtro) throws Exception;
	public UbigeoBean obtenerIdUbigeo(UbigeoBean ubigeo) throws Exception;
}
