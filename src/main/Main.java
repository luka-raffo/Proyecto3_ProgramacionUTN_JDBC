package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Main iniciado");
		
		
		
		DaoCategoria catDao = new DaoCategoria();
		
		Categoria cat = new Categoria();
		
		catDao.borrarCategoria(3);
		
		cat.setNombre("hola");
		
		catDao.agregarCategoria(cat);
		
		
		cat = catDao.obtenerCategoria(1);
		//System.out.println(cat.getNombre());
		
		ArrayList<Categoria> lCategoria = catDao.obtenerTodasLasCat();
		
		for(Categoria ca: lCategoria) {
			System.out.println(ca.toString());
		}
		
		DaoProducto proDao = new DaoProducto();
		
		Producto prod = new Producto("1b2","coca-cola",100.00f,32,1);
		Producto prodCopia = new Producto();
		//proDao.agregarProducto(prod);
		
		//prodCopia = proDao.obtenerProducto(prod.getCodigo());
		/*
		proDao.borrarProducto("1b2");
		
		ArrayList<Producto> lProductos = proDao.obtenerTodosLosProd();
		
		for(Producto pro: lProductos) {
			
			System.out.println(pro.toString());
		}
		*/
		
		
	}

}
