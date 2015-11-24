public class Index<T>{

  private char index;
  private DoublyLinkedList<T> lista;

  Index(){
    lista = new DoublyLinkedList<>();
    this.index = ' ';
  }

  Index(char index){
    lista = new DoublyLinkedList<>();
    this.index = index;
  }

  public void setIndex(char index){
    this.index = index;
  }

  public char getIndex(){
    return this.index;
  }

  public void addList(T o){
    lista.addOrdenado(o);
  }

  public DoublyLinkedList<T> getList(){
    return lista;
  }

}
