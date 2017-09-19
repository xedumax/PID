package com.redsocial.dao;


public class MySqlDAOFActory extends DAOFactory {

	

	@Override
	public UbigeoDAO getUbigeo() {
		return new MySqlUbigeo();
	}

	
}
