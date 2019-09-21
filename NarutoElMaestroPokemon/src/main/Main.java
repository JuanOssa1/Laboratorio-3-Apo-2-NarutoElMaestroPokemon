package main;

import java.util.Scanner;

import model.University;

public class Main {
	private Scanner dataRead;
	private University happyuniversity;
	public Main() {
		init();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.menu(0);
			
	}
	public void init() {
		happyuniversity = new University();
		dataRead = new Scanner(System.in);
	}
	public void menu(int myOption) {
		int option = myOption;
		if(option == 0) {
			showMenuOptions();
			option = dataRead.nextInt();
			dataRead.nextLine();
		}
		if(option == 1) {
			System.out.println("Ingrese el nombre del clan");
			String clanName = dataRead.nextLine();
			System.out.println(happyuniversity.createNewClan(clanName));
			menu(0);
		}else if(option == 2) {
			System.out.println("Ingrese el nombre del clan");
			String clanName = dataRead.nextLine();
			System.out.println(happyuniversity.showClans());
			menu(0);
		}else if(option == 3) {
			System.out.println("Ingrese el nombre nuevo del clan");
			String newName = dataRead.nextLine();
			System.out.println(happyuniversity);
		}else if(option == 4) {
			System.out.println("Ingrese el nombre del clan que quiere eliminar");
			String clanName = dataRead.nextLine();
			System.out.println(happyuniversity.deleteClan(clanName)); 
			menu(0);
		}else if(option == 5) {
			System.out.println("Aniadir un personaje al clan");
			System.out.println("Ingrese el nombre del clan al que agregara al personaje");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el nombre del personaje");
			String characterName = dataRead.nextLine();
			System.out.println("Ingrese la personalidad del personaje");
			String personality = dataRead.nextLine();
			System.out.println("Ingrese el dia de hoy en numeros");
			String currentDay = dataRead.nextLine();
			System.out.println("Ingrese el mes actual en numeros");
			String currentMonth = dataRead.nextLine();
			System.out.println("Ingrese el anio actual en numeros");
			String currentYear = dataRead.nextLine();
			String completeDate = currentDay+"/"+currentMonth+"/"+currentYear;
			System.out.println("Ingrese la cantidad de poder del personaje");
			int powerAbility = dataRead.nextInt(); dataRead.nextLine();
			System.out.println(happyuniversity.searchClanToAddCharacter(clanName, characterName, personality, completeDate, powerAbility));
			menu(0);
			
		}else if(option == 6) {
			System.out.println("Ingrese la id del clan al cual le quiere mostar los personajes");
			String clanName = dataRead.nextLine();
			System.out.println(happyuniversity.showCharactersInAClan(clanName));
			menu(0);
		}else if(option == 7) {
			
		}else if(option == 8) { 
			
		}else if(option == 9) {
			
		}else if(option == 10) {
			
		}else if(option == 11) {
			
		}else if(option == 12) {
			System.out.println("BAI BAI!");
		}
	}
	
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Crear un clan"); 
		System.out.println("2.  Mostrar clanes"); 
		System.out.println("3.  Actualizar informacion del clan"); 
		System.out.println("4.  Eliminar un clan"); 
		System.out.println("5.  Crear un personaje y aniadirlo a un clan"); 
		System.out.println("6.  Mostrar personajes en un clan");
		System.out.println("7.  Modificar atributos de un personaje");
		System.out.println("8.  Eliminar un personaje");
		System.out.println("9.  Crear una tecnica");
		System.out.println("10. Buscar una tecnica");																												
		System.out.println("11. Eliminar una tecnica");
	
		
		
		
	}


}