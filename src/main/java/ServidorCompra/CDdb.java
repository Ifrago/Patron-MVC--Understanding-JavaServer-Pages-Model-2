package ServidorCompra;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import ServidorCompra.CD;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CDdb {

	//Nos conectamos a la base de datos. ( el nombre se lo hemos dado en el context.xml
	private DataSource ds;
	public CDdb(){
		  try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/cdDB");
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
		}
	
	
	public List<CD> getCDList() throws SQLException{
		
		Connection con = ds.getConnection();//Hacemos la connexión
		
		//Preparamos la query
		Statement stmt = con.createStatement();//creamos para poder hacer una query
		String query = "select * from stock";//Construimos la query
		ResultSet rs = stmt.executeQuery(query);//Enviamos la query
		
		List llista = new LinkedList();//Creamos una lista para meter los nombres de los cd
		
		while(rs.next()){
			String album = rs.getString("cd_name");//De lo que nos da, cogemos la columna cd_name
			String autor=rs.getString("cd_author");//Cogemos la columna cd_author
			String country=rs.getString("cd_country");//Cogemos la columna cd_country
			double price=rs.getDouble("price");//Cogemos la columna del precio
			
			CD cdtemp = new CD();//Creamos un objeto tipo CD, para poner el nombre del album
			
			cdtemp.setAlbum(album);		//rellenamos el nombre del album de nuestro nuevo objeto ( cdtemp )
			cdtemp.setArtist(autor);	//Metemos al nuevoobjeto tipo CD el autor
			cdtemp.setCountry(country);	//Metemos al nuevo objeto el pais
			cdtemp.setPrice(price);		//Metemos el precio al nuevo objeto
			llista.add(cdtemp);			//Este nuevo objeto lo añadimos a la lista.
		}
		return llista;//Retornamos la lista
	}
}
