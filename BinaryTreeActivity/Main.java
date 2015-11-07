import java.sql.*;
import java.util.*;

public class Main{
  public static void main(String[] args) {

    Connection conexion;
    Statement st;
    ResultSet rs=null;
    ArbolB arbol = new ArbolB();


    try {
      Class.forName("com.mysql.jdbc.Driver"); //Comprobar el conector    org.gjt.mm.mysql.Driver
      conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica", "root", "root");
      st=conexion.createStatement();
    } catch (ClassNotFoundException ex) {
      System.out.println("Conector no encontrado. Mensaje de error: " + ex.getMessage());
    } catch (SQLException ex) {
      System.out.println("Error en SQL. Mensaje de error: " + ex.getMessage());
    }

    try{
      if (!conexion.isClosed()){
        rs = st.executeQuery("select * from customers"); //Ejecuta el query de SQL
        if(!rs.next()){
          System.out.println("No hay resultados que coincidan con la búsqueda.");
        }
      }else{ //Error en la conexión
        System.out.println("La conexión con la Base de Datos está cerrada.");
      }
    }catch(SQLException ex){
      System.out.println("Error " + ex.getMessage());
    }

    try {
      while(rs.next()){
        Customers customer = new Customers();
        customer.setCustomerID(rs.getString("CustomerID"));
        customer.setCompanyName(rs.getString("CompanyName	"));
        customer.setContactName(rs.getString("ContactName"));
        customer.setContactTitle(rs.getString("ContactTitle"));
        customer.setAddress(rs.getString("Address"));
        customer.setRegioDetail(rs.getString("City"),rs.getString("Region"),rs.getString("PostalCode"),rs.getString("Country"));
        customer.setContactDetail(rs.getString("Phone"),rs.getString("Fax"));
        arbol.insertar(customer);
      }
    } catch (SQLException ex) {
      System.out.println("Error " + ex.getMessage());
    }

    System.out.println ("Impresion inOrder: ");
    arbol.inOrder();



  }
}
