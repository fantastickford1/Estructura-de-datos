package Act_Sort;

import java.util.*;
/*
 *
 * @author VFRFB
 */

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private int edad;

	public Alumno(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	public Alumno(){

	}

	public int compareTo(Alumno o) {
		int resultado = this.nombre.compareTo(o.nombre);
		if ( resultado == 0){
			if (this.edad == o.edad){
				return 0;
			}
			else{
				if (this.edad <= o.edad){
					return -1;
				}
				else{
					return 1;
				}
			}
		}
		else{
			return resultado;
		}

    }
	
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setEdad(int edad){
		this.edad = edad;
	}

	public int getEdad(){
		return edad;
	}
	public String toString(){
		return nombre+":"+edad;
	}
	
}