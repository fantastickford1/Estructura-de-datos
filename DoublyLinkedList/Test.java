class Test{
  public static void main(String[] args) {
    DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
    doublyList.addOrdenado(5);
    doublyList.addOrdenado(3);
    doublyList.addOrdenado(0);
    doublyList.addOrdenado(8);
    doublyList.addOrdenado(1);
    System.out.println(doublyList.size());
    System.out.println(doublyList.iterateForward());
    System.out.println(doublyList.iterateBackward());


  }
}
