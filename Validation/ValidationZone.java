public class ValidationZone{

  private MyQueue dataQueue;
  private String expretion;
  private PilaChar exclm;
  private ListaSimple listCorrect;
  private ListaSimple listWrong;
  private char[] stringbreake;


  public ValidationZone(){
    dataQueue = new MyQueue(30);
    listCorrect = new ListaSimple();
    listWrong = new ListaSimple();
  }

  public ValidationZone(int size){
    dataQueue = new MyQueue(size);
    listCorrect = new ListaSimple();
    listWrong = new ListaSimple();
  }

  public void addString(String cadena){
    try {
      dataQueue.enqueue(cadena);
    }catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public void listValidation(){

    while (!dataQueue.isEmpty()) {
      try {
        this.expretion = dataQueue.dequeue().toString();
      }catch (Exception e) {
        System.err.println(e.getMessage());
      }
      if(validateExpretion(expretion) == true){
        listCorrect.add(expretion);
      }else
        listWrong.add(expretion);
    }
  }

  public void printList(){
    System.out.println("White List - print linkedlist: " + listCorrect);
    System.out.println("Black List - print linkedlist: " + listWrong);

  }

  private boolean validateExpretion(String expretion){
    boolean question = true;
    boolean exclamation = true;
    int i;
    String expretions = expretion;
    exclm = new PilaChar(expretions.length());
    stringbreake = expretions.toCharArray();
    for(i = 0; i < expretions.length(); i++){
      if(stringbreake[i] == 168 ){
        exclm.push(stringbreake[i]);
      }else if (stringbreake[i] == '?') {
        if (!exclm.isEmpty()) {
          exclm.pop();
        }else{
          question = false;
          break;
        }
      }
    }
    if(question == true){
      if (exclm.isEmpty()){
        question = true;
      }else
        question = false;
    }

    for(i = 0; i < expretions.length(); i++){
      if(stringbreake[i] == 173){
        exclm.push(stringbreake[i]);
      }else if (stringbreake[i] == '!') {
        if (!exclm.isEmpty()) {
          exclm.pop();
        }else{
          exclamation = false;
          break;
        }
      }
    }
    if(question == true){
      if (exclm.isEmpty()){
        question = true;
      }else
        question = false;
    }
    if(exclamation == true && question == true){
      return true;
    }else
      return false;
  }





}
