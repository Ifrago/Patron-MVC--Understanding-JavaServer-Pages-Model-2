<%@ page session="true"  import="ServidorCompra.CDdb" import="ServidorCompra.CD"  import="java.util.*"%>
<html>
<head>
 <title>Musica sin fronteras</title>
</head>
<body bgcolor="#33CCFF">
 <font face="Times New Roman,Times" size="+3">
  Music Without Borders
 </font>
 <hr><p>
 
  <center>
  <form name="shoppingForm" 
   action="/CompraOnline/ShoppingServlet" 
   method="POST">
 <b>CD:</b> 
 <select name=CD>
 <%
 	CDdb cd = new CDdb();//Ya tenemos la conexion BD
 	List llista= cd.getCDList();
 	for(int i =0;i< llista.size(); i++){
 		CD cdo=(CD)llista.get(i);//Cogemos un cd
 		
 %>	
  <option><%=cdo.getAlbum()%> | <%=cdo.getArtist()%>  | <%=cdo.getCountry()%> | <%=cdo.getPrice()%></option>
  <%}%>
 </select>
 <b>Quantity: </b><input type="text" name="qty" SIZE="3" value=1>
 <input type="hidden" name="action" value="ADD">
 <input type="submit" name="Submit" value="Add to Cart">
 </form>
 </center>
 <p>
 <jsp:include page="Cart.jsp" flush="true" />
</body>
</html>