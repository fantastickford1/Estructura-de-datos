package Act_Sort;

import java.util.*;
import esd.utils.*;
public class Comparar {
   
    public static void main(String arg[]) {    
		ArrayList<Alumno> lista = new ArrayList<Alumno>();	
         ArrayList<String> lString = new ArrayList<String>();
		 ArrayList<Persona> lPersona = new ArrayList<Persona>();	
		Alumno a1 = new Alumno("Juan Pablo",15);
        Alumno a2 = new Alumno("Juan Pablo",30);     
		Alumno a3 = new Alumno("Angel", 20);
		
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		System.out.println ("Comparar a1 y a2: " + a1.compareTo(a2));
		System.out.println ("Comparar a2 y a3: " + a2.compareTo(a3));
		System.out.println ("" );
		System.out.println ("Lista original: " + lista);
		Collections.sort(lista);
		System.out.println ("Lista Ordenada: " + lista);
		
		System.out.println ("Lista Sorts: " + Sorts.selectionSort(lista));
		
      } 
  
	  
}