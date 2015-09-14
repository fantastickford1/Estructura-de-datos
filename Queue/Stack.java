public class Stack{

  private Object pila[];
  private int tope;

  public Stack(int capacidad){
    pila = new Object[capacidad];
    tope = -1;
  }

  public boolean isEmpty(){
    return tope == -1;
  }

  public void push(Object i){
    if (tope+1 < pila.length)
      pila[++tope] = i;
  }

  public Object pop(){
    if(isEmpty())
      return 0;
    return pila[tope--];
  }

}
