public class Main{
  public static void main(String[] args) {
    ListaSimple<Integer> lista = new ListaSimple<>();
    lista.addOrdenado(2);
    lista.addOrdenado(5);
    lista.addOrdenado(4);
    System.out.println(lista.toString());

  }
}
