import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    //>>>>>>>>>>>>>>>>>>Objetos<<<<<<<<<<<<<<<<<<<
    Scanner keyboard = new Scanner(System.in);
    ValidationZone validString = new ValidationZone();
    //>>>>>>>>>>>>>>>>>>>>Variables<<<<<<<<<<<<<<<<<<<<<<<
    String expresion = "";
    //>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<
    System.out.println("Introduce expresiones y al finalizar introduce 'FIN'");
    while (!expresion.equals("FIN")) {
      expresion = keyboard.nextLine();
      if (!expresion.equals("FIN")) {
          validString.addString(expresion);
      }
    }
    validString.listValidation();
    validString.printList();
    }
}
