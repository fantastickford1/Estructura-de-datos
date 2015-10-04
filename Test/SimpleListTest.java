import org.junit.*;
import static org.junit.Assert.*;

public class SimpleListTest{

  @Test
  public void test_Constructor(){
    System.out.println("Validar Constructor");
    ListaSimple list = new ListaSimple();
    list.add("Hola");
    list.add("Bien");
    System.out.println("::::" + list.get(1).getData());
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
    System.out.println("::::::" + lists.toString());
  }

  @Test
  public void test_getPosition(){
    System.out.println("Validad get()");
    ListaSimple list = new ListaSimple();
    list.add();
    list.add();
    list.add();
    list.add();
    list.add();
    System.out.println("::::::" + );
  }



}
