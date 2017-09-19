package com.redsocial.dao;

import java.util.List;

import com.redsocial.bean.UbigeoBean;



public interface UbigeoDAO {

	
	
	public abstract List<UbigeoBean> traeDepartamentos() throws Exception;
	public abstract List<UbigeoBean> traeProvincias(UbigeoBean ubigeoBean) throws Exception;
	public abstract List<UbigeoBean> traeDistritos(UbigeoBean ubigeoBean) throws Exception;

}
