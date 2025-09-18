
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;
import entidad.Producto;

public class DaoProducto {

	private String host= "jdbc:mysql://localhost:3307/"; //cambiar a 3306 yo lotengo en 3307
	private String user = "root";
	private String pass= "root";
	private String dbName= "bdinventario";
	
	
	public DaoProducto() {
	
	}
	
	
	public int agregarProducto(Producto prod) {
		String query = "INSERT INTO productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('"
			    + prod.getCodigo() + "', '"
			    + prod.getNombre() + "', "
			    + prod.getPrecio() + ", "
			    + prod.getStock() + ", "
			    + prod.getIdCategoria() + ")";
		
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
	
public int borrarProducto(String codigo) {
		
		int filas = 0;
		
		String query = "Delete FROM productos WHERE Codigo = '" + codigo + "'";
		
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
	
	
public boolean modificarProducto(Producto producto) {
    String query = "UPDATE productos SET Nombre = '" + producto.getNombre() + 
                   "' WHERE Codigo = " + producto.getCodigo();
    Connection cn = null;
    boolean actualizado = false;

    try {
        cn = DriverManager.getConnection(host+dbName,user,pass);
        Statement st = cn.createStatement();
        int filasAfectadas = st.executeUpdate(query);

        if (filasAfectadas > 0) {
            actualizado = true;
            System.out.println("Producto modificada correctamente.");
        } else {
            System.out.println("No se encontró el producto con ese codigo.");
        }

    } catch(Exception e) {
        e.printStackTrace();
        System.out.println("Error al modificar el producto.");
    } 
    return actualizado;
}
	
public ArrayList <Producto>obtenerTodosLosProd(){
		
		Connection cn = null;
		
		ArrayList<Producto> lProductos = new ArrayList<Producto>();
		
		String query = "SELECT * FROM productos";
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			ResultSet re = st.executeQuery(query);
			while(re.next()) {
				Producto prod = new Producto();
				prod.setCodigo(re.getString("Codigo"));
				prod.setNombre(re.getString("Nombre"));
				prod.setPrecio(re.getFloat("Precio"));
				prod.setStock(re.getInt("Stock"));
				prod.setIdCategoria(re.getInt("IdCategoria")); 	
				lProductos.add(prod);
			}
			
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		return lProductos;
	}
	
	
public void agregarProductoSP(Producto prod) {
		Connection cn = null;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			CallableStatement cst = cn.prepareCall("Call sp_AgregarProducto(?,?,?,?,?)");
			cst.setString(1, prod.getCodigo());
			cst.setString(2, prod.getNombre());
			cst.setFloat(3, prod.getPrecio());
			cst.setInt(4, prod.getStock());
			cst.setInt(5, prod.getIdCategoria());

			cst.execute();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
			System.out.println("no correcto");
		
		}
		
		
	}
	
	
}

