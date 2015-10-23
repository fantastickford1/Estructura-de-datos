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
		/*Merge<T> merge;
		merge= new Merge<T>();*/
		listaOrdenada= mergeEort(listaOrdenada);
		//Collections.sort(listaOrdenada); //aqui agregar lo necesario para ordenar
		return listaOrdenada;
	}

	///////////////////////////////////////////////////////
	public static <T extends Comparable<T>> ArrayList<T> mergeEort(ArrayList<T> arreglo){
		//Si lista esta vacía o de tamaño 1 ya está ordenada. Se devuelve lista tal cual
		if(arreglo.size() <= 1){
			return arreglo;
		}else{
			int medio = arreglo.size()/2;
			ArrayList<T> tempA = new ArrayList<T>(medio);
			ArrayList<T> tempB = new ArrayList<T>(arreglo.size()-medio);
			for (int i=0;i<arreglo.size() ; i++ ) {
				if(i<medio){
					tempA.add(arreglo.get(i));
				}else{
					tempB.add(arreglo.get(i));
				}
			}
			ArrayList<T> izq = mergeEort(tempA);
			ArrayList<T> der = mergeEort(tempB);
			return merge(izq, der);
		}
	}

	public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> izq, ArrayList<T> der){
		int i = 0; //indice izq
		int j = 0; //indece der
		int index =0;
		ArrayList<T> resultado = new ArrayList<T>(izq.size()+der.size());
		while(i<izq.size() && j<der.size()){
			if(izq.get(i).compareTo(der.get(j)) < 0){
				resultado.add(izq.get(i++));
			}else{
				resultado.add(der.get(j++));
			}
		}
		while( i<izq.size() ){    // Copia el resto de la mitad izq
            resultado.add(izq.get(i++));
        }
        while( j<der.size()){ //Copia el resto de la mitad der
            resultado.add(der.get(j++));
        }
        return resultado;
	}

	//////////////////////////////////////////////////////


}
