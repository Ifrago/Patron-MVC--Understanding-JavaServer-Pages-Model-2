package ServidorCompra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ServidorCompra.CD;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CDCarrito {

	double price=0.0;
	int numCD=0;
	
	//Nos conectamos a la base de datos. ( el nombre se lo hemos dado en el context.xml )
		private DataSource ds;
		public CDCarrito(){
			  try {
				Context ctx = new InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/cdDB");
			  } catch (NamingException e) {
				e.printStackTrace();
			  }
			}
		public void InsertQuantity(int num){//Recogemos la cantidad de CDs de cada tipo y lo vamos sumando al total
			numCD=num+numCD;
		}
		public void InsertAmount( String precio){//Recogemos el precio total
			price=Double.parseDouble(precio);
		}
		public void InsertQuery() throws SQLException{	
			

			Connection con = ds.getConnection();//Hacemos la connexión
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO carrito (car_numcd,car_price) VALUE (?,?)");			
			//metemos en la query el numCD y el precio total
			pstmt.setInt(1, numCD);
			pstmt.setDouble(2, price);
			pstmt.executeUpdate();
			
		}
	
}
