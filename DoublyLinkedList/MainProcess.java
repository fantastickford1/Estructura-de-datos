import java.util.Scanner;

public class MainProcess{
	
	private DoublyLinkedList<Index<Kryta>> linkedList;
	private Index<Kryta> recoverIndexOb;
	private Scanner keyboard;
	private String data;
	private boolean foundIt = false;
	
	public MainProcess(){
		linkedList = new DoublyLinkedList<>();
		keyboard = new Scanner(System.in);
	}
	
	public void menu(){
		System.out.println();
		System.out.println(">>>>>>>>>Welcome!!<<<<<<<<<");
		System.out.println(">>>>>>Directory v 2.0<<<<<<");
		System.out.println("1. Add a person");
		System.out.println("2. List the directory");
		System.out.println("3. Exit");
		System.out.println();
		String opcion = keyboard.nextLine();
		
		switch(opcion){
			case "1":{
				addFolk();
				menu();
				break;	
			}
			case "2":{
				showAll();
				menu();
				break;
			}
			case "3":{
				
				break;	
			}
			default:{
				menu();
				break;
			}
		}
	}
	
	private void addFolk(){
		Kryta folk = new Kryta();
		System.out.println("Ingrese el nombre:");
		data = keyboard.nextLine();
		folk.setName(data);
		System.out.println("Ingrese la direccion");
		data = keyboard.nextLine();
		folk.setAddress(data);
		System.out.println("Ingrese el numero de telefono");
		long numero = keyboard.nextLong();
		folk.setPhone(numero);
		char index = folk.getIndex();
		
		if(linkedList.isEmpty()){
			Index<Kryta> newIndex = new Index<>(index);
			newIndex.addList(folk);
			linkedList.addOrdenado(newIndex);
		}else{
			for(int i = 1; i <= linkedList.size(); i++){
				recoverIndexOb = linkedList.get(i);
				char recoveredIndex = recoverIndexOb.getIndex();
				if(recoveredIndex == index){
					foundIt = true;
					break;
				}
				foundIt = false;
			}
			if(foundIt != false){
				recoverIndexOb.addList(folk);
			}else{
				Index<Kryta> newIndex = new Index<>(index);
				newIndex.addList(folk);
				linkedList.addOrdenado(newIndex);
			}
		}		
	}
	
	private void showAll(){
		System.out.println();
		System.out.println("1. Acendente");
		System.out.println("2. Decendente");
		System.out.println();
		String opc = keyboard.nextLine();
		switch(opc){
			case "1" :{
				linkedList.iterateForward();
				break;
			}
			case "2" :{
				linkedList.iterateBackward();
				break;
			}
			default:{
				showAll();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		MainProcess mainP = new MainProcess();
		mainP.menu();
    
  	}
	
	
}