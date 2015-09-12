// void enqueue( obj ) --> Inserta objeto
// Object dequeue( ) --> Remueve y regresa el siguiente elemento
// Object peek( ) --> Muestra el siguiente elemento sin alterar la estructura
// boolean isEmpty( ) --> true si está vacia; false si tiene elementos
// int size() --> Implementar: Cantidad de elementos en la estructura

public class MyQueue {

  public static final int DEFAULT_SIZE=5;
  private Object data[];
  private int index;

  public MyQueue(){
    data=new Object[DEFAULT_SIZE];
  }

  public MyQueue(int s){
    data=new Object[s];
  }

  public boolean isEmpty(){
    return index==0;
  }

  public void enqueue(Object obj) throws Exception{
    if(index==DEFAULT_SIZE-1){
      throw new Exception("Queue is full. Dequeue some objects");
    }
    this.data[index]=obj;
    this.index++;
  }

  public Object dequeue() throws Exception{
    if(isEmpty())throw new Exception("Queue is empty");
    Object obj=this.data[0];
    for(int i =0; i<this.index-1; i++){
      data[i]=data[i+1];
    }
    this.index--;
    return obj;
  }

  public Object peek() throws Exception{
    if(isEmpty())throw new Exception("Queue is empty");
    return this.data[0];
  }

  public static void main(String[] args) throws Exception {
    MyQueue queue = new MyQueue();
    queue.enqueue("a");
    System.out.println("dequeue:"+queue.dequeue());
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");
    System.out.println("dequeue:"+queue.dequeue());
    System.out.println("peek:"+queue.peek());
    System.out.println("dequeue:"+queue.dequeue());
    queue.enqueue("1");
    queue.enqueue("2");
  }

}
