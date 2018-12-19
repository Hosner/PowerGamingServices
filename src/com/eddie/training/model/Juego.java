package com.eddie.training.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Juego implements ValueObject, Comparable<Juego>{
	private Integer idJuego=null;
	private String nombre = null;
	private Date fechaLanzamiento = null;
	private String informacion = null;
	private String requisitos = null;
	private Integer id_creador = null;
	
	private List<Edicion> ediciones = null;	
	private List<Categoria> categorias=null;
	private List<Idioma> idiomas=null;
	private List<Plataforma> plataformas=null;
	private List<Guia> guias=null; 
	
	public Juego() {
		ediciones= new ArrayList<Edicion>();
		categorias = new ArrayList<Categoria>();
		idiomas=new ArrayList<Idioma>();
		plataformas= new ArrayList<Plataforma>();
		guias=new ArrayList<Guia>();
	}
	
	public Juego(Integer idJuego, String nombre, String informacion) {
		setIdJuego(idJuego);
		setNombre(nombre);
		setInformacion(informacion);
	}
	
	public Juego(String nombre, String informacion,String requisitos) {
		setNombre(nombre);
		setInformacion(informacion);
		setRequisitos(requisitos);
	}
	

	public Integer getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Integer idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public List<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	public Integer getId_creador() {
		return id_creador;
	}

	public void setId_creador(Integer id_creador) {
		this.id_creador = id_creador;
	}

	@Override
	public int compareTo(Juego j) {
		return this.getFechaLanzamiento().compareTo(j.getFechaLanzamiento());
		
	}
	
	public int compareTo2(Juego j) {
		return this.getNombre().compareTo(j.getNombre());
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

	public List<Guia> getGuias() {
		return guias;
	}

	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}
	

	/*SI HUBIERA HERENCIA*/
	
	/* 
	 * super.toString( ) + atributos
	 * 
	 * */
	
	
	
	
}

