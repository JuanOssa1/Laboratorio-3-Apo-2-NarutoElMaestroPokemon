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
			happyuniversity.createNewClan(clanName);	
		}else if(option == 2) {
			System.out.println("Ingrese el nombre del clan");
			String clanName = dataRead.nextLine();
			System.out.println(happyuniversity.showClans());
		}else if(option == 3) {
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
			
		}else if(option == 4) {
			
		}else if(option == 5) {
			
		}else if(option == 7) {
			
		}else if(option == 9) {
			
		}else if(option == 10) {
			
		}else if(option == 11) {
			
		}else if(option == 12) {
			
		}else if(option == 13) {
			
		}else if(option == 14) {
			
		}
	}
	
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Crear un clan"); 
		System.out.println("2.  Mostrar un clanes"); 
		System.out.println("3.  Aniadir informacion a un clan ya creado"); 
		System.out.println("4.  Eliminar un clan"); 
		System.out.println("5.  Crear un personaje y aniadirlo a un clan"); 
		System.out.println("6.  Buscar personajes en un clan");
		System.out.println("7.  Modificar atributos de un personaje");
		System.out.println("8.  Eliminar un personaje");
		System.out.println("9.  Crear una tecnica");
		System.out.println("10. Buscar una tecnica");																												
		System.out.println("11. Eliminar una tecnica");
	
		
		
		
	}


}
