package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import entidad.Categoria;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Main iniciado");
		
		DaoCategoria catDao = new DaoCategoria();
		
		Categoria cat = new Categoria();
		/*
		cat.setNombre("hola");
		
		catDao.agregarCategoria(cat);
		*/
		
		cat = catDao.obtenerCategoria(1);
		//System.out.println(cat.getNombre());
		
		ArrayList<Categoria> lCategoria = catDao.obtenerTodasLasCat();
		
		for(Categoria ca: lCategoria) {
			System.out.println(ca.toString());
		}
		
	}

}
