package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {

	private String host= "jdbc:mysql://localhost:3307/"; //cambiar a 3306 yo lotengo en 3307
	private String user = "root";
	private String pass= "root";
	private String dbName= "bdinventario";
	
	
	public DaoCategoria() {
		
	}
	
	public int agregarCategoria(Categoria cat) {
		String query = "Insert into categorias(Nombre) values ('"+cat.getNombre()+"')";
		
		Connection cn = null;
		
		int filas = 0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
			System.out.println("correecto");
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		
		
		return filas;
	}
	
public int borrarCategoria(int id) {
		
		int filas = 0;
		
		String query = "Delete FROM categorias WHERE IdCategoria = '" + id + "'";
		
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
			System.out.println("correecto");
			
			

			
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		
		
		return filas;
	}
	
	
	public Categoria obtenerCategoria(int idCategoria) {
		
		Categoria cat = new Categoria();
		
		String query = "SELECT * FROM categorias WHERE IdCategoria = " + idCategoria;
		
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			ResultSet re = st.executeQuery(query);
			re.next();
			System.out.println("correecto");
			cat.setNombre(re.getNString("Nombre"));
			cat.setId(re.getInt("IdCategoria"));
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		
		
		return cat;
	}
	
	
	public ArrayList <Categoria>obtenerTodasLasCat(){
		
		Connection cn = null;
		
		ArrayList<Categoria> lCategorias = new ArrayList<Categoria>();
		
		String query = "SELECT * FROM categorias";
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			ResultSet re = st.executeQuery(query);
			while(re.next()) {
				Categoria cat = new Categoria();
				cat.setNombre(re.getNString("Nombre"));
				cat.setId(re.getInt("IdCategoria")); 	
				lCategorias.add(cat);
			}
			
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		return lCategorias;
	}
	
}
