package com.redsocial.dao;


public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	//objetos daos
	
	public abstract UbigeoDAO getUbigeo();
	
	// Se aplica polimorfismo
	public static DAOFactory getFactorty(int bd) {
		switch (bd) {
			case MYSQL:
				return new MySqlDAOFActory();
			
		}
		return null;
	}

	

}
