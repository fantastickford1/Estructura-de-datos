public class MenuClassQuick{
  public static void main(String[] args) {
    Quicksort quick = new Quicksort();

    int[] array = {3,4,8,6,7,2,9,1,5,0};

    quick.quickSort(array,0,9);

    for (int i = 0; i < array.length ; i++ ) {
      System.out.print("["+array[i]+"]");
    }

  }
}
