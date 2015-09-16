public class QueueSorting{

  private static final int SIZE = 30;
  private String temp;
  private String temp2;
  private String phr;
  private int sd;
  private MyQueue order;
  private MyQueue mayor;

  public QueueSorting(){
    order = new MyQueue(SIZE);
    mayor = new MyQueue(SIZE);
  }

  public void sortAll(String phrase){
    this.phr = phrase;
    try {
      if(order.isEmpty()){
        order.enqueue(phr);
      }else{
        sd = order.size();
        for (int cnt = 1;cnt <= sd;cnt++) {
          temp = order.dequeue().toString();
          if(phr.compareTo(temp)<0){
            mayor.enqueue(temp);
          }else {
            order.enqueue(temp);
          }
        }
        order.enqueue(phr);
        while (!mayor.isEmpty()) {
          temp2 = mayor.dequeue().toString();
          order.enqueue(temp2);
        }
      }
    }catch(Exception e){
      System.err.println(e.getMessage());
    }
  }



  public void getSorting(){
    try {
      while (!order.isEmpty()) {
        System.out.println(order.dequeue());
      }
    }catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }


}
