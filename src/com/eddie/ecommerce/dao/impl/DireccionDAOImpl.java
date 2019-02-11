package com.eddie.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eddie.ecommerce.dao.DireccionDAO;
import com.eddie.ecommerce.dao.Utils.ConnectionManager;
import com.eddie.ecommerce.dao.Utils.JDBCUtils;
import com.eddie.ecommerce.exceptions.DataException;
import com.eddie.ecommerce.exceptions.DuplicateInstanceException;
import com.eddie.ecommerce.exceptions.InstanceNotFoundException;
import com.eddie.ecommerce.model.Direccion;


public class DireccionDAOImpl implements DireccionDAO{

	private static Logger logger=LogManager.getLogger(DireccionDAOImpl.class);
	
	@Override
	public Direccion findById(Connection conexion,String email) throws InstanceNotFoundException, DataException {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Email = "+email);
		}
		
		Direccion d=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conexion=ConnectionManager.getConnection();
			String sql;
			sql="select id_direccion,id_provincia,email,codigo_postal,calle,numero,piso,localidad from direccion where email=?";
			
			logger.debug(sql);
			pst=conexion.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int i=1;
			//pst.setString(i++,"%"+nombrejuego.toUpperCase()+"%");
			pst.setString(i++, email);	
			rs=pst.executeQuery();
			
			if(rs.next()){
				d=loadNext(rs);
			}else {
				throw new InstanceNotFoundException("Error "+email+" id introducido incorrecto", Direccion.class.getName());
			}
			return d;
		}catch (SQLException ex) {
			logger.error(ex.getMessage(),ex);
			throw new DataException(ex);
		}finally{
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(pst);
		}
	}

	@Override
	public Direccion create(Connection conexion,Direccion d) throws DuplicateInstanceException, DataException {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Direccion = "+d.toString());
		}
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conexion=ConnectionManager.getConnection();
			String sql;
			sql="Insert Into direccion(id_provincia,email,codigo_postal,calle,numero,piso,localidad) "
					+ "values (?,?,?,?,?,?)";
			
			pst=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			pst.setInt(i++, d.getIdprovincia());
			pst.setString(i++, d.getCodigoPostal());
			pst.setString(i++, d.getCalle());
			pst.setString(i++, d.getNumero());
			pst.setString(i++, d.getPiso());
			pst.setString(i++, d.getLocalidad());

			logger.debug(sql);
			
			int insertRow=pst.executeUpdate();
			
			if(insertRow == 0) {
				throw new SQLException(" No se pudo insertar");
			}
			
			return d;
		}catch (SQLException ex) {
			logger.error(ex.getMessage(),ex);
			throw new DataException(ex);
		}finally{
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(pst);
		}
	}

	@Override
	public boolean update(Connection conexion,Direccion d) throws InstanceNotFoundException, DataException {
		
		if(logger.isDebugEnabled()){
			logger.debug("Direccion = "+d.toString());
		}
		
		PreparedStatement preparedStatement = null;
		conexion=null;
		StringBuilder sqlupdate;
		try {	
			conexion=ConnectionManager.getConnection();
			sqlupdate = new StringBuilder(" UPDATE direccion");
			
			boolean first = true;
			
			if (d.getIdprovincia()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," id_provincia = ?");
				first=false;
			}
			
			if (d.getCodigoPostal()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," codigo_postal = ?");
				first=false;
			}
			
			if (d.getCalle()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," calle = ?");
				first=false;
			}
			
			if (d.getNumero()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," numero = ?");
				first=false;
			}
					
			if (d.getPiso()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," piso = ?");
				first=false;
			}
			
			if (d.getLocalidad()!=null) {
				JDBCUtils.addUpdate(sqlupdate,first," localidad = ?");
				first=false;
			}
			
			sqlupdate.append("WHERE email = ?");
			
			preparedStatement = conexion.prepareStatement(sqlupdate.toString());
			

			int i = 1;
			if (d.getIdprovincia()!=null) 
				preparedStatement.setInt(i++,d.getIdprovincia());
			
			if (d.getCodigoPostal()!=null) 
				preparedStatement.setString(i++,d.getCodigoPostal());
			if (d.getCalle()!=null) 
				preparedStatement.setString(i++,d.getCalle());
			if (d.getNumero()!=null) 
				preparedStatement.setString(i++,d.getNumero());
			
			if (d.getPiso()!=null) 
				preparedStatement.setString(i++,d.getPiso());
			
			if (d.getLocalidad()!=null) 
				preparedStatement.setString(i++,d.getLocalidad());
			
			preparedStatement.setString(i++, d.getEmail());

			logger.debug(sqlupdate);
			
			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows > 1) {
				throw new SQLException();
			}     
			return true;
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
			throw new DataException(e);    
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}              		
	}

	@Override
	public void delete(Connection conexion,String email) throws DataException {
		
		if(logger.isDebugEnabled()) {
			logger.debug("Email = "+email);
		}
		
		PreparedStatement preparedStatement = null;

		try {
			String queryString =	
					  "DELETE FROM direccion " 
					+ "WHERE email = ? ";
			
			preparedStatement = conexion.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, email);

			logger.debug(queryString);
			
			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(email, "fallo al eliminar direccion");
			} 
			

		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
		
	}
	
	public Direccion loadNext(ResultSet rs) 
			throws SQLException,DataException{
				int i=1;
				Integer idDireccion  = rs.getInt(i++);
				String email=rs.getString(i++);
				Integer idProvincia = rs.getInt(i++);
				String codigoPostal=rs.getString(i++);
				String calle=rs.getString(i++);
				String numero=rs.getString(i++);
				String piso=rs.getString(i++);
				String localidad=rs.getString(i++);
				
				Direccion d= new Direccion();
				d.setIdDireccion(idDireccion);
				d.setEmail(email);
				d.setIdprovincia(idProvincia);
				d.setCodigoPostal(codigoPostal);
				d.setCalle(calle);
				d.setNumero(numero);
				d.setPiso(piso);
				
				return d;
				
			
		}

}