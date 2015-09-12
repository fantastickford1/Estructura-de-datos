//java org.junit.runner.JUnitCore [test class name]

import org.junit.*;
import static org.junit.Assert.*;

public class PilaCharTest{

  @Test
  public void test_PilaChar(){
    System.out.println("Valida Constructor");
    PilaChar prueba = new PilaChar(10);
    assertTrue(prueba.isEmpty());
  }





}
