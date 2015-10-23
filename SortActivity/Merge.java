import java.util.*;

public class Merge<T extends Comparable<T>>{
/*
Error indexoutofbound line=16
try to fix it
*/
	public ArrayList<T> merge_sort(ArrayList<T> arreglo){
		//Si lista esta vacía o de tamaño 1 ya está ordenada. Se devuelve lista tal cual
		System.out.println(arreglo.size());
		if(arreglo.size() <= 1){
			return arreglo;
		}else{
			int medio = arreglo.size()/2;
			ArrayList<T> tempA = new ArrayList<T>(medio);
			ArrayList<T> tempB = new ArrayList<T>(arreglo.size()-medio);
			for (int i=0;i<arreglo.size() ; i++ ) {
				System.out.println(i);
				if(i<medio){
					tempA.add(arreglo.get(i));
				}else{
					tempB.add(arreglo.get(i));
				}
			}
			ArrayList<T> izq = merge_sort(tempA);
			ArrayList<T> der = merge_sort(tempB);
			return merge(izq, der);
		}
	}

	private ArrayList<T> merge(ArrayList<T> izq, ArrayList<T> der){
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



}
