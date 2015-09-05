import java.util.Scanner;


public class TestM{
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    System.out.println("Introduce la formula");
    String formula = keyboard.nextLine();
    char[] newform = formula.toCharArray();
    PilaChar pila = new PilaChar(formula.length());
    for (int i = 0;i<formula.length() ; i++ ) {
      if(newform[i] == '('){
        pila.push(newform[i]);
      }else if (newform[i] == ')') {
        if (!pila.isEmpty()) {
          pila.pop();
        }else {
          pila.push(')');
        }
      }
    }
    if (pila.isEmpty()){
      System.out.println("Formato correcto");
    }else
      System.out.println("Formato incorrecto");


  }
}
