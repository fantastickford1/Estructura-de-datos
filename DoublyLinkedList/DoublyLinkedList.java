public class DoublyLinkedList<T>{
    // Referencia  a el node raiz o la cabeza de la lista.
    private Node<T> head;
    private Node<T> tail;
    private int listCount;

    // constructor
    public DoublyLinkedList() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node<>(null);
        tail = new Node<>(null);
        listCount = 0;
    }

    public void add(T data)
    // Agrega el nodo al final de la lista.
    {
        Node<T> Temp = new Node<>(data);
        Node<T> FirstOne = head;
        Node<T> LastOne = tail;
    // Si la lista esta vacia se agrega el nuevo nodo
        if(FirstOne.getNext() == null ){
          FirstOne.setNext(Temp);
          LastOne.setLast(Temp);
        }else{ //Si tiene algo se agrega el nodo al final de la lista
          Temp.setLast(LastOne.getLast());
          LastOne.getLast().setNext(Temp);
          LastOne.setLast(Temp);
        }
        listCount++;
    }

     public T get(int index)
    // Regresa el dato localizado en el nodo indicado
    {
        if (index <= 0)
            return null;

        Node<T> Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current.getData();
    }

    public boolean remove(int index)
    // remueve el elemento en la posición indicada
    {
        //
        if (index < 1 || index > size())
            return false;
        Node<T> Current = head;
        int a = index +1;
        for (int i = 1; i <= index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.getLast().setNext(Current.getNext());
        Current.getNext().setLast(Current.getLast());
        Current.setNext(null);
        Current.setLast(null);

        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public boolean addPos(int index, T data)
    // agrega el elemento en la posición indicada
    {
      if (index < 1) {
        return false;
      }
      if(index > size()){
        add(data);
        return true;
      }

      Node<T> Current = head;

      for (int i = 1; i < index ; i++ ) {
        Current = Current.getNext();
      }
      Node<T> Temp;
      if (index == 1) {
        Temp = new Node<T>(data,Current.getNext(),null);
      }else{
        Temp = new Node<T>(data,Current.getNext(),Current);
      }
      Current.getNext().setLast(Temp);
      Current.setNext(Temp);
      listCount++;
      return true;
    }

    public <Object extends Comparable<Object>> boolean addOrdenado(T data)
    // agrega el elemento en la posición indicada
    {
        Node<T> Current = head;
        int a=1;
        Object data1 = (Object) data;
        while(Current.getNext()!=null &&
        data1.compareTo((Object)Current.getNext().getData()) > 0) {
          Current = Current.getNext();
          a++;
        }
        return addPos(a,data);
    }

    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }

    public boolean isEmpty(){
      return listCount == 0;
    }

    public void iterateForward()
    {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            Index<Kryta> tempw = (Index) Current.getData();
            System.out.println("---->>" + tempw.getIndex() + "<<----");
            output = "[" + Current.getData().toString() + "]";
            System.out.println(output);
            System.out.println();
            Current = Current.getNext();
        }
    }

    public void iterateBackward()
    {
        Node<T> Current = tail.getLast();
        String output = "";
        while (Current != null) {
          Index<Kryta> tempw = (Index) Current.getData();
          System.out.println("---->>" + tempw.getIndex() + "<<----");
          output = "[" + Current.getData().toString() + "]";
          System.out.println(output);
          System.out.println();
          Current = Current.getLast();
        }
    }

}
