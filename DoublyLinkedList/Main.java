import java.util.*;

class Main{
  public static void main(String[] args) {
//>>>>>>>>>>>>>>>>Clases<<<<<<<<<<<<<<<<<<<<<<
    Scanner keyboard;
    Kryta forlks;
    Index<Kryta> theIndex;
    DoublyLinkedList<Index> list;
//>>>>>>>>>>>>>>>>Variables<<<<<<<<<<<<<<<<<<<
    String name = null;
    String addres = null;
    String phone = null;
    String obtion = null;
    boolean launch = true;
////////////////////Objetos///////////////////////////
    keyboard = new Scanner(System.in);

///////////////////////MainProces//////////////////////////////
    while (launch) {
      System.out.println("Seleccione una obcion");
      System.out.println("1. Agregar");
      System.out.println("2. Enlistar");
      System.out.println("3. Salir");
      obtion = keyboard.nextLine();
      switch (obtion) {
        case "1" :{
          //First.-Get the data
          System.out.println("Introduce nombre");
          name = keyboard.nextLine();
          System.out.println("Introduce direccion");
          addres = keyboard.nextLine();
          System.out.println("Introduce telefono");
          phone = keyboard.nextLine();
        }
        case "2" :{

        }
        case "3" :{
          launch = false;
        }
      }
    }
    System.out.println(name);
    System.out.println(addres);
    System.out.println(phone);
  }
}
