import java.util.*;

public class Sorts  {


	public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		/*Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar*/
		return listaOrdenada;
	}

	public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		T aux;
		for (int i = 1; i < listaOrdenada.size(); i++) {
				aux = listaOrdenada.get(i);
				for (int j = i-1; j >=0 && listaOrdenada.get(j).compareTo(aux) == 1; j--) { //mayor
						listaOrdenada.set(j+1,listaOrdenada.get(j));
						listaOrdenada.set(j,aux);
				}
		}
		//Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar
		return listaOrdenada;
	}


	public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		Quicksort<T> quick;
		quick = new Quicksort<T>();
		quick.quickSort(listaOrdenada,0,listaOrdenada.size()-1);
		//Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar
		return listaOrdenada;
	}

	public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar
		return listaOrdenada;
	}


	public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		Merge<T> merge;
		merge= new Merge<T>();
		listaOrdenada= merge.merge_sort(listaOrdenada);
		//Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar
		return listaOrdenada;
	}


}
