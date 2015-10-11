public class MenuClassBubble{

  public static void main(String[] args) {
    BubbleSort bubble = new BubbleSort();
    int[] array = {3,4,8,6,7,2,9,1,5,0};

    bubble.bubbleSort(array);

    for (int i = 0; i < array.length ; i++ ) {
      System.out.print("["+array[i]+"]");
    }

  }



}
