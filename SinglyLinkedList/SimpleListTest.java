import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

public class SimpleListTest{

  @Test
  public void test_Constructor(){
    System.out.println("Validar Constructor");
    ListaSimple list = new ListaSimple();
    list.add("Hola");
    list.add("Bien");
    assertEquals("failure - Strings are not equals","Hola",list.get(1).getData());
  }

  @Test
  public void test_Ordenar(){
    System.out.println("Validar Ordenamiento");
    ListaSimple lists = new ListaSimple();
    lists.addOrdenado("Nacho");
    lists.addOrdenado("Tere");
    lists.addOrdenado("Pacheco");
    lists.addOrdenado("Diana");
    lists.addOrdenado("Carlos");
    lists.addOrdenado("Zenteno");
    assertEquals("failure - array are not equals","Diana",lists.get(2).getData());
  }

  @Test
  public void test_getPosition(){
    System.out.println("Validad get()");
    ListaSimple list = new ListaSimple();
    list.add("Tere");
    list.add("Nacho");
    list.add("Diana");
    list.add("Carlos");
    list.add("Karen");
    assertEquals("failure - strings are not equal","Diana",list.get(3).getData());
  }

  @Test
  public void test_toString(){
    System.out.println("Validar toString()");
    ListaSimple list = new ListaSimple();
    list.add("Diana");
    list.add("Carlos");
    list.add("Tere");
    list.add("Nacho");
    list.add("Karen");
    list.add("Susi");
    assertEquals("failure - strings are not equal",list.toString(),"[Diana][Carlos][Tere][Nacho][Karen][Susi]");
  }



}
