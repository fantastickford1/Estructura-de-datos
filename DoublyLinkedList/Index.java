public class Index<T> implements Comparable<Index>{

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
  
  @Override
  public String toString(){
    String datos = "";
    for(int i = 1; i <= lista.size(); i++){
      Kryta person = (Kryta) lista.get(i);
      datos += "{" + person.getName() + " - " + person.getAddres() + " - " + person.getPhone() + "}";
    }
    return datos;
  }
  
  @Override
  public int compareTo(Index o){
    if(this.index > o.getIndex()){
      return 1;
    }
    if(this.index < o.getIndex()){
      return -1;
    }
    return 0;
  }

}
