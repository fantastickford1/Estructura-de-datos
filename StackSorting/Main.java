import java.util.Scanner;

public class Main{
  public static void main(String[] args) {

    String ph = "";
    int size;

    StringSort sorting;
    MyQueue fila = new MyQueue(20);
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Ingrese una palabra seguido de la tecla 'Enter' al finalizar escriba 'FIN'");
    while (!ph.equals("FIN")) {
      ph = keyboard.next();
      if (!ph.equals("FIN")) {
        try {
          fila.enqueue(ph);
        }catch (Exception e) {
          System.err.println(e.getMessage());
        }
      }
    }
    size = fila.size();
    sorting = new StringSort(size);
    sorting.sortAll(fila);
    System.out.println("String ordenados alfabeticamente:");
    sorting.getSorting();
    

  }
}
