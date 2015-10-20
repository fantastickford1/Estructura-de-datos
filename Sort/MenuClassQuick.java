public class MenuClassQuick{
  public static void main(String[] args) {
    Quicksort quick = new Quicksort();
    AnalizaFile readed = new AnalizaFile("milDatosReverse.txt");
    int[] all = readed.getAllLinesInt(",");

    quick.quickSort(all,0,999);

    for (int i = 0; i < all.length ; i++ ) {
      System.out.print("["+all[i]+"]");
    }
    System.out.println();
    System.out.println("The main process was repeated: " + quick.count);

  }
}
