public class PilaChar{

  private Object pila[];
  private int tope;

  public PilaChar(int capacidad){
    pila = new Object[capacidad];
    tope = -1;
  }

  public boolean isEmpty(){
    return tope == -1;
  }

  public void push(char i){
    if (tope+1 < pila.length)
      pila[++tope] = i;
  }

  public Object pop(){
    if(isEmpty())
      return 0;
    return pila[tope--];
  }

  public String toString(){
    return new String(pila,0,tope+1);
  }
}
