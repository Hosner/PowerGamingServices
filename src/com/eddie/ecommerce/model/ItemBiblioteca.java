package com.eddie.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

public class ItemBiblioteca extends AbstractValueObject implements Comparable<ItemBiblioteca>, Serializable {

	private String email=null;
	private Integer puntuacion=null;
	private Integer idJuego=null;
	private Date fechaComentario=null;
	private String comentario=null;
	private String comprado=null;
	private String nombreUsuario = null;

	public ItemBiblioteca() {

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getComprado() {
		return comprado;
	}

	public void setComprado(String comprado) {
		this.comprado = comprado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaCompra) {
		this.fechaComentario = fechaCompra;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int compareTo(ItemBiblioteca b) {
		return this.getPuntuacion()-b.getPuntuacion();
		
	}
	
}
