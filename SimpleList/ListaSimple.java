class ListaSimple <T> {
    // Referencia  a el node raiz o la cabeza de la lista.
    private Node<T> head;
    private int listCount;
    //private T data1;

    // constructor
    public ListaSimple() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node<>(null);
        listCount = 0;
    }

    public void add(T data)
    // Agrega el nodo al final de la lista.
    {
        Node<T> Temp = new Node<>(data);
        Node<T> Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next"
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }

     public Node<T> get(int index)
    // Regresa el nodo en la posición indicada por index
    {
        if (index <= 0)
            return null;

        Node<T> Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }

    public boolean remove(int index)
    // remueve el elemento en la posición indicada
    {
        //
        if (index < 1 || index > size())
            return false;
        Node<T> Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public boolean addPos(int index, T data)
    // agrega el elemento en la posición indicada
    {
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data);
            return true;
        }
        Node<T> Current = head;
        int a=index+1;
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        Node<T> Temp = new Node<>(data,Current.getNext());
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }


/*public boolean addOrdenado(T data)
    // agrega el elemento en la posición indicada
    {
        Node<T> Current = head;
        int a=1;
        T data1 = data;
        while(Current.getNext()!=null && (String)data1.compareTo((String)Current.getNext().getData()) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data1);
    }*/


    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }

    public String toString() {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

    /*private int compareTo(T object){
      if(this.data1 == object){
        return 0;
      }else if((String)this.data1 > (String)object){
        return 1;
      }else
        return -1;
    }*/

    //>>>>>>>>>>>>>>>NODE<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public class Node <T> {
        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node<T> next;
        T data;
        // Node constructor
        public Node(T dataValue) {
            next = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(T dataValue, Node<T> nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public T getData() {
            return data;
        }

        public void setData(T dataValue) {
            data = dataValue;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> nextValue) {
            next = nextValue;
        }
    }
}
