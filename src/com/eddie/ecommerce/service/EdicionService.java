package com.eddie.ecommerce.service;


import java.sql.SQLException;
import java.util.List;

import com.eddie.ecommerce.exceptions.DataException;
import com.eddie.ecommerce.exceptions.DuplicateInstanceException;
import com.eddie.ecommerce.exceptions.InstanceNotFoundException;
import com.eddie.ecommerce.model.Edicion;

public interface EdicionService {
	
	//Busqueda de las ediciones de un juego
	public List<Edicion> findByIdJuego(Integer id) throws DataException, SQLException;
	
	public Edicion create(Edicion e) throws DuplicateInstanceException, DataException, SQLException;
	
	public boolean update(Edicion e) throws InstanceNotFoundException, DataException, SQLException;		
	
}