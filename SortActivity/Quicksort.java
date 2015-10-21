import java.util.*;

public class Quicksort <T extends Comparable<T>>{

  public void quickSort(ArrayList<T> arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }

  private int partition(ArrayList<T> arr, int left, int right){
    int i = left, j = right;
    T tmp;
    T pivot = arr.get((left + right) / 2);
    while (i <= j) {
      while (arr.get(i).compareTo(pivot)== -1)
        i++;
      while (arr.get(j).compareTo(pivot) == 1)
        j--;
      if (i <= j) {
        tmp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,tmp);
        i++;
        j--;
      }
    };
    return i;
  }

}
