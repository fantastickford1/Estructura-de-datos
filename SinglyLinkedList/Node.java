public class Node <T>{
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
