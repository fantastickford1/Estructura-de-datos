import java.sql.*;
import java.util.*;
import java.io.*;

public class Process{

  Scanner keyboard;
  Conexion conect = null;
  ResultSet rs=null;
  ArbolB arbol;

  public Process(){
    keyboard = new Scanner(System.in);
    arbol = new ArbolB();
  }

  public void menuContext(){
    System.out.println();
    System.out.println("//////////////////////");
    System.out.println("WELCOME");
    System.out.println("1. Leer registros - almacenar en arbol");
    System.out.println("2. Listar arbol");
    System.out.println("3. Limpiar el nodo");
    System.out.println("4. Guardar arbol");
    System.out.println("5. Recuperar arbol");
    System.out.println("6. Exit");
    int ob = keyboard.nextInt();
    switch (ob) {
      case 1:{
        readDataBase();
        menuContext();
        break;
      }
      case 2:{
        System.out.println();
        System.out.println ("Impresion inOrder: ");
        arbol.inOrder();
        menuContext();
        break;
      }
      case 3:{
        arbol.delete();
        System.out.println("Arbol borrado");
        menuContext();
        break;
      }
      case 4:{
        saveTree();
        System.out.println();
        menuContext();
        break;
      }
      case 5:{
        recoverTree();
        menuContext();
        break;
      }
      case 6: break;

      default:{
        menuContext();
        break;
      }
    }
  }

  private void readDataBase(){
    System.out.println("Conecting....");
    try {
      conect = new Conexion("root","root","practica");
      System.out.println("Conected c: ");
    }catch (ClassNotFoundException | SQLException e) {
      System.err.println(e.getMessage());
    }
    rs = conect.buscar("select * from customers");
    System.out.println("Saving data in binary tree...");
    try {
      while(rs.next()){
        Customers customer = new Customers();
        customer.setCustomerID(rs.getString("CustomerID"));
        customer.setCompanyName(rs.getString("CompanyName"));
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
    System.out.println("Saved c: ");
  }

  private void saveTree(){
    try
      {
         final FileOutputStream fo = new FileOutputStream("arbol.bin");
         final ObjectOutputStream oos = new ObjectOutputStream(fo);
         oos.writeObject(arbol);
         oos.flush();
         oos.close();
         System.out.println("Saved");
      }
      catch (Exception ex)
      {
         // write stack trace to standard error
         ex.printStackTrace();
         System.out.println("Error - Can't save");
      }
  }

  private void recoverTree(){
    try
      {
         final FileInputStream fis = new FileInputStream("arbol.bin");
         final ObjectInputStream ois = new ObjectInputStream(fis);
         final Object deserializedObject = ois.readObject();
         System.out.println("Tipo de objeto " + deserializedObject.getClass().getName());
         if (deserializedObject instanceof ArbolB)
         {
            arbol = (ArbolB) deserializedObject;
         }
         else
         {
            System.out.println("No se esperaba " + deserializedObject.getClass().getName());
         }
         ois.close();

         if (arbol != null)
         {
            System.out.println("Recovered");
         }
      }
      catch (Exception ex)
      {
         //
         System.out.println("Can't recover");
         ex.printStackTrace();
      }
  }
}
