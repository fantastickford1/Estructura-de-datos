public class ListaSimple {
    // Referencia  a el node raiz o la cabeza de la lista.
    private Node head;
    private int listCount;

    // constructor
    public ListaSimple() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data)
    // Agrega el nodo al final de la lista.
    {
        Node Temp = new Node(data);
        Node Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next"
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }

     public Object get(int index)
    // Regresa el nodo en la posici�n indicada por index
    {
        if (index <= 0)
            return null;

        Node Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current.getData();
    }

    public boolean remove(int index)
    // remueve el elemento en la posici�n indicada
    {
        //
        if (index < 1 || index > size())
            return false;
        Node Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }

    public String toString() {
        Node Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

    private class Node {
        //Referencia al siguiente elemento o a NULL si es el ultimo
        Node next;
        Object data;
        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
        // Constructor que incluye el siguiente nodo
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
