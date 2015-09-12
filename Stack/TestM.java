import java.util.Scanner;


public class TestM{
  public static void main(String[] args) {

    StockValidation skvalidation;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Introduce la formula");
    String formula = keyboard.nextLine();
    char[] newform = formula.toCharArray();
    PilaChar pila = new PilaChar(formula.length());
    skvalidation = new StockValidation(formula,newform);
    if(skvalidation.validate(pila) == true){
        System.out.println("Formato correcto");
    }else
      System.out.println("Formato incorrecto");


  }
}
