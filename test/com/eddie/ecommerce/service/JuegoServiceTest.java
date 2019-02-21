package com.eddie.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.eddie.ecommerce.exceptions.DataException;
import com.eddie.ecommerce.exceptions.DuplicateInstanceException;
import com.eddie.ecommerce.model.Categoria;
import com.eddie.ecommerce.model.Idioma;
import com.eddie.ecommerce.model.Juego;
import com.eddie.ecommerce.model.JuegoCriteria;
import com.eddie.ecommerce.model.Plataforma;
import com.eddie.ecommerce.service.impl.CategoriaServiceImpl;
import com.eddie.ecommerce.service.impl.JuegoServiceImpl;

public class JuegoServiceTest {
	private JuegoService serviceJ=null;
	private CategoriaService serviceC=null;
	public JuegoServiceTest() {
		serviceJ=new JuegoServiceImpl();
		serviceC=new CategoriaServiceImpl();
	}
	
	public void testfindAllJuego() {
		
			
			List<Juego> juegos;
			try {
				juegos =serviceJ.findAllByDate();
				for(Juego j : juegos){
				    System.out.println(j.getNombre());
				}
			} catch (DataException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	
	public void testfindbyCriteria() {
		
			JuegoCriteria ju=new JuegoCriteria();
			
			Categoria ca=new Categoria();
			Categoria cate=new Categoria();
			List<Categoria> cat=new ArrayList();
//			ca.setIdCategria(3);
//			cat.add(ca);
		
			
			Idioma idiom=new Idioma();
//			idiom.setIdIdioma("ESP");
			List<Idioma>idiomas=new ArrayList();
//			idiomas.add(idiom);
			Plataforma plataf=new Plataforma();
//			plataf.setIdPlatadorma(1);
			List<Plataforma> plataforma=new ArrayList();
//			plataforma.add(plataf);
			
			ju.setNombre("dia");
			ju.setCategoria(cat);
			ju.setIdioma(idiomas);
			ju.setPlataforma(plataforma);
			
			List<Juego> juegos;
			try {
				juegos =serviceJ.findByJuegoCriteria(ju, "ES");
				for(Juego j:juegos) {
					System.out.println(j.getNombre());
					for(Categoria categoria: j.getCategoria()) {
						System.out.println(categoria.getNombre());
					}
				}
				
			} catch (DataException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public void testfindid() {
		
			Juego juegos;
			try {
				juegos =serviceJ.findById(12, "ES");
				System.out.println(juegos.getNombre()+","+juegos.getIdiomas().get(0).getNombre()+",Fecha "+juegos.getFechaLanzamiento());
				
			} catch (DataException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void create() throws DuplicateInstanceException, DataException {
		
			Juego juegos=new Juego("prueba",new Date(),2);
			try {
				juegos =serviceJ.create(juegos);
				System.out.println("Juego creado: "+juegos.getNombre()+", "+juegos.getIdCreador()+", "+juegos.getFechaLanzamiento());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void testfindValoracion() {
		
			List<Juego> juegos;
			try {
				juegos =serviceJ.findAllByValoración();
				for(Juego j : juegos){
				    System.out.println(j.getIdJuego()+",Fecha "
				    		+ ""+j.getFechaLanzamiento());
				}
			} catch (DataException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void testFindByDate() {
		
			List<Juego> juegos;
			try {
				juegos =serviceJ.findAllByDate();
				for(Juego j : juegos){
				    System.out.println(j.getIdJuego()+","+j.getFechaLanzamiento());
				}
			} catch (DataException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	public static void main(String[] args) {
		JuegoServiceTest test = new JuegoServiceTest();
		//test.testFindByDate();
		//test.testfindValoracion();
		test.testfindbyCriteria();
		/*
		try {
			
			test.create();
		} catch (DuplicateInstanceException e) {
			e.printStackTrace();
		} catch (DataException e) {
			e.printStackTrace();
		}
		*/
		//test.testfindAllJuego();
		//test.testfindid();

	}

}
