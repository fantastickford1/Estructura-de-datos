public class StockValidation{

  private String formula;
  private char[] newform;

  public StockValidation(String formula, char[] newform){
    this.formula = formula;
    this.newform = newform;
  }

  public boolean validate(PilaChar pila){
    for (int i = 0;i<formula.length() ; i++ ) {
      if(newform[i] == '('){
        pila.push(newform[i]);
      }else if (newform[i] == ')') {
        if (!pila.isEmpty()) {
          pila.pop();
        }else {
          return false;
        }
      }
    }
    if (pila.isEmpty()){
      return true;
    }else
      return false;
  }

}
