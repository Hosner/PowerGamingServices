package com.eddie.ecommerce.model;

import java.io.Serializable;

public class Provincia implements Serializable {
	private Integer idProvincia=null;
	private String nombre=null;
	private Integer idPais=null;
	
	
	public Provincia() {
		
	}
	public Integer getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	
	
	
}
