
<<<<<<< HEAD
=======
import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Main iniciado");
		
		DaoCategoria catDao = new DaoCategoria();
		
		Categoria cat1 = new Categoria("alimento");
		Categoria cat2 = new Categoria("automovil");
		Categoria cat3 = new Categoria("bebida");
		Categoria cat4 = new Categoria("cosmeticos");
		Categoria cat5 = new Categoria("carniceria");
		Categoria cat6 = new Categoria("viviendas");
		Categoria cat7 = new Categoria("alquileres");
		Categoria cat8 = new Categoria("encendedores");
		Categoria cat9 = new Categoria("llantas");
		Categoria cat10 = new Categoria("musica");
	
		
		catDao.agregarCategoria(cat1);
		catDao.agregarCategoria(cat2);
		catDao.agregarCategoria(cat3);
		catDao.agregarCategoria(cat4);
		catDao.agregarCategoria(cat5);
		catDao.agregarCategoria(cat6);
		catDao.agregarCategoria(cat7);
		catDao.agregarCategoria(cat8);
		catDao.agregarCategoria(cat9);
		catDao.agregarCategoria(cat10);

		catDao.borrarCategoria(3);
		
		Categoria catModificada = new Categoria();
        catModificada.setId(2);
        catModificada.setNombre("vehiculos");
        catDao.modificarCategoria(catModificada);
		
		ArrayList<Categoria> lCategoria = catDao.obtenerTodasLasCat();
		
		for(Categoria ca: lCategoria) {
			System.out.println(ca.toString());
		}
		
		DaoProducto proDao = new DaoProducto();
		
		Producto prod1 = new Producto("1","pizza",100.00f,32,1);
		Producto prod2 = new Producto("2","empanadas",100.00f,32,1);
		Producto prod3 = new Producto("3","bife",100.00f,32,1);
		Producto prod4 = new Producto("4","pancho",100.00f,32,1);
		Producto prod5 = new Producto("5","hamburguesa",100.00f,32,1);
		Producto prod6 = new Producto("6","vacio",100.00f,32,1);
		Producto prod7 = new Producto("7","yogurt",100.00f,32,1);
		Producto prod8 = new Producto("8","helado",100.00f,32,1);
		Producto prod9 = new Producto("9","naranja",100.00f,32,1);
		Producto prod10 = new Producto("10","manzama",100.00f,32,1);
		
		
		proDao.agregarProducto(prod1);
		proDao.agregarProducto(prod2);
		proDao.agregarProducto(prod3);
		proDao.agregarProducto(prod4);
		proDao.agregarProducto(prod5);
		proDao.agregarProducto(prod6);
		proDao.agregarProducto(prod7);
		proDao.agregarProducto(prod8);
		proDao.agregarProducto(prod9);
		proDao.agregarProductoSP(prod10);;
		
		
		proDao.borrarProducto("2");
		
		 Producto prodModificado = new Producto("5", "hamburguesa doble", 250.00f, 50, 1);
	     proDao.modificarProducto(prodModificado);
		
		ArrayList<Producto> lProductos = proDao.obtenerTodosLosProd();
		
		for(Producto pro: lProductos) {
			
			System.out.println(pro.toString());
		}
		
		
		
	}

}
>>>>>>> 36a931f (fixing bugs)
