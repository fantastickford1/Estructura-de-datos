public class Kryta implements Comparable<Kryta>{

  private String name;
  private String addres;
  private Long phone;
  private char index;

  public void setName(String name){
    this.name = name;
  }

  public void setAddres(String addres){
    this.addres = addres;
  }

  public void setPhone(Long phone){
    this.phone = phone;
  }

  public String getName(){
      return this.name;
  }

  public String getAddres(){
    return this.addres;
  }

  public Long getPhone(){
    return this.phone;
  }

  public char getIndex(){
    String Name = this.name.toUpperCase();
    char[] charName = Name.toCharArray();
    return charName[0];
  }

  @Override
  public int compareTo(Kryta o){
    int mayor = this.name.compareTo(o.getName());
    return mayor;
  }


}
