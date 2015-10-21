public class MenuClassQuick{
  public static void main(String[] args) {
    Quicksort quick = new Quicksort();
    Quicksort quick2 = new Quicksort();
    Quicksort quick3 = new Quicksort();
    AnalizaFile first = new AnalizaFile("mildatos.txt");
    AnalizaFile second = new AnalizaFile("mildatosAleatorios.txt");
    AnalizaFile third = new AnalizaFile("milDatosReverse.txt");

    int[] best = first.getAllLinesInt(",");
    int[] normal = second.getAllLinesInt(",");
    int[] bad = third.getAllLinesInt(",");

    quick.quickSort(best,0,999);
    for (int i = 0; i < best.length ; i++ ) {
      System.out.print("["+best[i]+"]");
    }
    System.out.println();
    System.out.println("Best case");
    System.out.println("The main process was repeated: " + quick.count);

    quick2.quickSort(normal,0,999);
    for (int i = 0; i < normal.length ; i++ ) {
      System.out.print("["+normal[i]+"]");
    }
    System.out.println();
    System.out.println("Normal case");
    System.out.println("The main process was repeated: " + quick2.count);

    quick3.quickSort(bad,0,999);
    for (int i = 0; i < bad.length ; i++ ) {
      System.out.print("["+bad[i]+"]");
    }
    System.out.println();
    System.out.println("Bad case");
    System.out.println("The main process was repeated: " + quick3.count);

  }
}
