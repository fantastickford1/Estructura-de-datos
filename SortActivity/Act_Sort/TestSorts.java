// java org.junit.runner.JUnitCore [test class name]

/*
UNIVERSIDAD POLITECNICA DE CHIAPAS

@author DIANA ALONDRA TOLEDO MAZA  143355
@author CARLOS ALEJANDRO ZENTENO ROBLES 143382
*/

import static org.junit.Assert.*;
import java.util.*;
import esd.utils.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestSorts {

    private static final ArrayList<Integer> iList = new ArrayList<Integer>
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

    @Test
    public void testSelectionSort() {
		ArrayList<Integer> sList = new ArrayList<Integer>(iList);
		Collections.sort(sList);  //sortedList, lista ordenada
		System.out.println("");
		System.out.println("Testing sList <> iList");
		assertThat(sList, is(not(iList)));
		System.out.println("Testing sList = selectionSort(iList)");
		assertThat(sList, is(Sorts.selectionSort(iList)));

    }
	@Test
	    public void testInsertionSort() {
		ArrayList<Integer> sList = new ArrayList<Integer>(iList);
		Collections.sort(sList);  //sortedList, lista ordenada
		System.out.println("");
		System.out.println("Testing sList <> iList");
		assertThat(sList, is(not(iList)));
		System.out.println("Testing sList = insertionSort(iList)");
		assertThat(sList, is(Sorts.insertionSort(iList)));

    }

	@Test
	    public void testQuickSort() {
		ArrayList<Integer> sList = new ArrayList<Integer>(iList);
		Collections.sort(sList);  //sortedList, lista ordenada
		System.out.println("");
		System.out.println("Testing sList <> iList");
		assertThat(sList, is(not(iList)));
		System.out.println("Testing sList = QuickSort(iList)");
		assertThat(sList, is(Sorts.quickSort(iList)));

    }

	@Test
	    public void testHeapSort() {
		ArrayList<Integer> sList = new ArrayList<Integer>(iList);
		Collections.sort(sList);  //sortedList, lista ordenada
		System.out.println("");
		System.out.println("Testing sList <> iList");
		assertThat(sList, is(not(iList)));
		System.out.println("Testing sList = HeapSort(iList)");
		assertThat(sList, is(Sorts.heapSort(iList)));

    }


	@Test
	    public void testMergeSort() {
		ArrayList<Integer> sList = new ArrayList<Integer>(iList);
		Collections.sort(sList);  //sortedList, lista ordenada
		System.out.println("");
		System.out.println("Testing sList <> iList");
		assertThat(sList, is(not(iList)));
		System.out.println("Testing sList = MergeSort(iList)");
		assertThat(sList, is(Sorts.mergeSort(iList)));

    }

}
