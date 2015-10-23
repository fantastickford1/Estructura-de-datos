package esd.utils;
import java.util.*;

/*
UNIVERSIDAD POLITECNICA DE CHIAPAS

@author DIANA ALONDRA TOLEDO MAZA  143355
@author CARLOS ALEJANDRO ZENTENO ROBLES 143382
*/

public class Sorts  {

	public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		for (int i = 0;i<listaOrdenada.size() ;i++ ) {
			T menor= listaOrdenada.get(i);
			int pos= i;
			for (int j= i+1;j< listaOrdenada.size() ;j++ ) {
				if(listaOrdenada.get(j).compareTo(menor)<0){
					menor= listaOrdenada.get(j);
					pos= j;
				}
			}
			listaOrdenada.set(pos, listaOrdenada.get(i));
			listaOrdenada.set(i, menor);
		}
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
		return listaOrdenada;
	}


	public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		quick(listaOrdenada,0,listaOrdenada.size()-1);
		return listaOrdenada;
	}

	public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		ordenacionMonticulos(listaOrdenada);
		return listaOrdenada;
	}


	public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> list){
		ArrayList<T> listaOrdenada;
		listaOrdenada = new ArrayList<T>(list);
		ArrayList<T> a;
		listaOrdenada = mergeEort(listaOrdenada);
		return listaOrdenada;
	}

////////////////////////METODOS DE LAS ALGORITMOS DE ORDENAMIENTO//////////////////////////////////


	//>>>>>>>>>>>>>>>>>>>>>>>QUICKSORT<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static <T extends Comparable<T>> void quick(ArrayList<T> arr, int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quick(arr, left, index - 1);
    if (index < right)
      quick(arr, index, right);
  }

  public static <T extends Comparable<T>> int partition(ArrayList<T> arr, int left, int right){
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

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MERGE<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>HEAP<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public static <T extends Comparable<T>> void ordenacionMonticulos(ArrayList<T> v) {
        final int N = v.size();
        for(int nodo = N/2; nodo>=0; nodo--) hacerMonticulo(v, nodo, N-1);
        for(int nodo = N-1; nodo>=0; nodo--) {
            T tmp = v.get(0);
            v.set(0, v.get(nodo));
            v.set(nodo, tmp);
            hacerMonticulo(v, 0, nodo-1);
        }
    }

    public static <T extends Comparable<T>> void hacerMonticulo(ArrayList<T> v, int nodo, int fin) {
        int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= v.get(izq).compareTo(v.get(der))>0?izq:der;
        if(v.get(nodo).compareTo(v.get(may))<0 ) {
            T tmp = v.get(nodo);
            v.set(nodo, v.get(may));
            v.set(may, tmp);
            hacerMonticulo(v, may, fin);
        }
    }


}


/*
UNIVERSIDAD POLITECNICA DE CHIAPAS

@author DIANA ALONDRA TOLEDO MAZA  143355
@author CARLOS ALEJANDRO ZENTENO ROBLES 143382
*/
