import java.util.*;

public class Main{
  public static void main(String[] args) {

    ArrayList<Integer> iList = new ArrayList<Integer>
            (Arrays.asList(
            534,946,17,	749,566,
            552,304,732,230,374,
            850,584,199,33,225,
            159,437,809,183,383,
            681,294,611,771,269,
            561,902,508,720,830,
            395,326,761,783,614,
            606,278,892,129,882,
            945,80,46,522,302,
            669,70,706,268,649
            ));
    ArrayList<Integer> sList = new ArrayList<Integer>(Sorts.mergeSort(iList));
    System.out.println(sList);

  }
}
