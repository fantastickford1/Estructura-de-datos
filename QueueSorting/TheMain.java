import java.util.Scanner;

public class TheMain{
  public static void main(String[] args) {

    String ph = "";
    int size;

    QueueSorting sorting = new QueueSorting();
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Ingrese una palabra seguido de la tecla 'Enter' al finalizar escriba 'FIN'");
    while (!ph.equals("FIN")) {
      ph = keyboard.next();
      if (!ph.equals("FIN")) {
          sorting.sortAll(ph);
      }
    }
    System.out.println("String ordenados alfabeticamente:");
    sorting.getSorting();


  }
}
