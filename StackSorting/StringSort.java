public class StringSort{

  private int SIZE;
  private String temp;
  private String temp2;
  private boolean isMinor = false;
  //MyQueue queue;
  private Stack order;
  private Stack mayor;

  public StringSort(int size){
    this.SIZE = size;
  }

  public void sortAll(MyQueue fila){
    //queue = new MyQueue(SIZE);
    order = new Stack(SIZE);
    mayor = new Stack(SIZE);
    while (!fila.isEmpty()) { //while the queue is not empty, get the first String in temp.
      try {
        temp = fila.dequeue().toString();
      }catch (Exception e) {
        System.err.println(e.getMessage());
      }
      if (order.isEmpty()) {
        order.push(temp);
      }else{
        while(!order.isEmpty()){
          temp2 = order.pop().toString();
          if(temp.compareTo(temp2)<0){
            mayor.push(temp2);
          }else{
            order.push(temp2);
            break;
          }
        }
        order.push(temp);
        while (!mayor.isEmpty()) {
          temp = mayor.pop().toString();
          order.push(temp);
        }
      }
    }
  }



  public void getSorting(){
    while (!order.isEmpty()) {
      System.out.println(order.pop());
    }
  }


}
