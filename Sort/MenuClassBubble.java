public class MenuClassBubble{

  public static void main(String[] args) {

    BubbleSort bubble = new BubbleSort();
    AnalizaFile readed = new AnalizaFile("mildatos.txt");
    int[] all = readed.getAllLinesInt(", ");

    bubble.bubbleSort(all);

    for (int i = 0; i < all.length ; i++ ) {
      System.out.print("["+all[i]+"]");
    }
    System.out.println();
    System.out.println("The main process was repeated: " + bubble.contador);
  }



}
