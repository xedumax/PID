package com.redsocial.service;

import java.util.List;

import com.redsocial.bean.UbigeoBean;
import com.redsocial.dao.DAOFactory;
import com.redsocial.dao.UbigeoDAO;



public class UbigeoServiceImpl implements UbigeoService{

	DAOFactory factoria = DAOFactory.getFactorty(DAOFactory.MYSQL);
	UbigeoDAO dao = factoria.getUbigeo();
	
	
	public List<UbigeoBean> traeDepartamentos() throws Exception {
		return dao.traeDepartamentos();
	}
	
	public List<UbigeoBean> traeProvincias(UbigeoBean ubigeoBean)throws Exception {
		return dao.traeProvincias(ubigeoBean);
	}
	
	public List<UbigeoBean> traeDistrito(UbigeoBean ubigeoBean)	throws Exception {
		return dao.traeDistritos(ubigeoBean);
	}


	
	
	
	
}
