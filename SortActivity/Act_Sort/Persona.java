package Act_Sort;

public class Persona {

	private String nombre;
	private int edad;

	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona(){

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

}