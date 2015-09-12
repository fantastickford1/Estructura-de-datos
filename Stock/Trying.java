public class Trying{
  public static void main(String[] args) {
    PilaChar pila = new PilaChar(3);
    Object sd[];
    pila.push("S");
    pila.push("D");
    //System.out.println(pila.pop());
    pila.push("W");
    pila.sneak();
    int we = 0;
    while (sd[we] != null) {
      System.out.println(sd[we]);
      we++;
    }
  }
}
