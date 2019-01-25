package com.eddie.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eddie.ecommerce.dao.PaisDAO;
import com.eddie.ecommerce.dao.Utils.ConnectionManager;
import com.eddie.ecommerce.dao.Utils.JDBCUtils;
import com.eddie.ecommerce.exceptions.DataException;
import com.eddie.ecommerce.exceptions.InstanceNotFoundException;
import com.eddie.ecommerce.model.Pais;

public class PaisDAOImpl implements PaisDAO{

	@Override
	public Pais findById(Connection conexion, Integer id) throws InstanceNotFoundException,DataException {
		Pais p=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
	try {
		conexion=ConnectionManager.getConnection();
		String sql;
		sql="select id_pais, nombre from pais where id_pais= ? ";
		
		pst=conexion.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		int i=1;
		pst.setInt(i++, id);
		
		rs=pst.executeQuery();
		
		
		while(rs.next()){
			p=loadNext(rs);
			
		}
		return p;
	}catch (SQLException ex) {
		throw new DataException(ex);
	}finally{
		JDBCUtils.closeConnection(conexion);
		JDBCUtils.closeResultSet(rs);
		JDBCUtils.closeStatement(pst);
	}
	}

	@Override
	public List<Pais> findAllBy(Connection conexion) throws DataException {
		Pais p=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conexion=ConnectionManager.getConnection();
			String sql;
			sql="select id_pais, nombre from pais";

			pst=conexion.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=pst.executeQuery();
			
			List<Pais> resultado=new ArrayList<Pais>();
			while(rs.next()){
				p=loadNext(rs);
				resultado.add(p);
			}
			return resultado;
		}catch (SQLException ex) {
			throw new DataException(ex);
		}finally{
			JDBCUtils.closeConnection(conexion);
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(pst);
		}
	}
	public Pais loadNext(ResultSet rs) 
			throws DataException,SQLException{
				int i=1;
				Integer idPais  = rs.getInt(i++);
				String nombre = rs.getString(i++);
				
				
				Pais p= new Pais();
				p.setIdPais(idPais);
				p.setNombre(nombre);
				
				
				return p;
			
		}
}
