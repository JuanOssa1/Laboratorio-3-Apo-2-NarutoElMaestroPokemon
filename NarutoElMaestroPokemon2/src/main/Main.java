package main;

import java.util.InputMismatchException;
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
			
				option = dataRead.nextInt();dataRead.nextLine();
				
			
		}
		if(option == 1) {
			//happyuniversity.startProgramLoadClans();
			System.out.println("Ingrese el nombre del clan");
			String clanName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyuniversity.createNewClan(clanName));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 2) {
			//System.out.println("Ingrese el nombre del clan");
			//String clanName = dataRead.nextLine();
			long t1 = System.nanoTime();
			happyuniversity.sortClansWithSelection();
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ordenando tardo: "+ save);
			long t3 = System.nanoTime();
			System.out.println(happyuniversity.showClans());
			long t4 = System.nanoTime();
			long save1 = t4-t3;
			System.out.println("Ejecucion "+save1);
			menu(0);
		}else if(option == 3) {
			System.out.println("Ingrese el nombre nuevo del clan");
			String newName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyuniversity.changeClanName(newName));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 4) {
			System.out.println("Ingrese el nombre del clan que quiere eliminar");
			String clanName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyuniversity.deleteClan(clanName)); 
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
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
			long t1 = System.nanoTime();
			System.out.println(happyuniversity.searchClanToAddCharacter(clanName, characterName, personality, completeDate, powerAbility));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
			
		}else if(option == 6) {
			System.out.println("Ingrese la id del clan al cual le quiere mostar los personajes");
			String clanName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyuniversity.organizeListOfCharacters(clanName));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ordenando: "+save );
			long t3 = System.nanoTime();
			System.out.println(happyuniversity.showCharactersInAClan(clanName));
			long t4 = System.nanoTime();
			long save1 = t4 -t3;
			System.out.println("Ejecucion: "+save1 );
			menu(0);
		}else if(option == 7) {
			System.out.println("Modificar atributos de un personaje");
			System.out.println("Ingrese el nombre del clan al cual el personaje hace parte");
			String clanName = dataRead.nextLine(); 
			System.out.println("Ingrese el nombre actual del personaje");
			String currentName = dataRead.nextLine();
			System.out.println("Ingrese el nuevo nombre del personaje");
			String newCharacterName = dataRead.nextLine();
			System.out.println("Ingrese la nueva personalidad");
			String personality = dataRead.nextLine();
			System.out.println("Ingrese el nuevo poder");
			int powerAbility = dataRead.nextInt(); dataRead.nextLine();
			System.out.println("Ingrese el nuevo dia de creacion");
			String newDay = dataRead.nextLine();
			System.out.println("Ingrese el nuevo mes de creacion");
			String newMonth = dataRead.nextLine();
			System.out.println("Ingrese el nuevo anio de creacion");
			String newYear = dataRead.nextLine();
			String completeNewDate = newDay+"/"+newMonth+"/"+newYear;
			long t1 = System.nanoTime();
			System.out.println("El personaje que se cambio fue: " + happyuniversity.changeCharacterAtributes(clanName, currentName, newCharacterName, personality, completeNewDate, powerAbility));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 8) { 
			System.out.println("Ingrese el nombre del clan del personaje");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el nombre del personaje que quiere eliminar");
			String narutoCharacter = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println("El personaje eliminado fue: " + happyuniversity.deleteCharacter(clanName, narutoCharacter));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 9) {
			System.out.println("Ingrese el nombre del clan donde se encuentra el personaje para aniadir la tecnica");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el nombre del personaje al cual le quiere agregar la habilidad");
			String characterNaruto = dataRead.nextLine();
			System.out.println("Ingrese el nombre de la tecnica");
			String technique = dataRead.nextLine();
			System.out.println("Ingrese el factor de influencia");
			int influenceFactor = dataRead.nextInt(); dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println("Tecnica agregada al personaje: " + happyuniversity.addTechniquetoAcharacter(clanName, characterNaruto, technique, influenceFactor));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 10) {
			System.out.println("Ingrese el clan dodne se encuentra el personaje");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el el nombre del personaje");
			String characterName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println("Las tecnicas del personaje son: "+ happyuniversity.showCharacterTechniques(clanName, characterName));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 11) {
			System.out.println("Ingrese el clan donde se encuentra el personaje");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el del nombre del personaje al cual le quiere eliminar la tecnica");
			String characterName = dataRead.nextLine();
			System.out.println("Ingrese el nombre de la tecnica que quiere eliminar");
			String techniqueToDelete = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println("La tecnica eliminada fue: "+happyuniversity.deleteCharacterTechnique(clanName, characterName, techniqueToDelete));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 12) {
			System.out.println("Ingrese el clan donde se encuentra el personaje");
			String clanName = dataRead.nextLine();
			System.out.println("Ingrese el del nombre del personaje al cual le quiere eliminar la tecnica");
			String characterName = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println("El poder total del personaje: "+""+ characterName +" "+happyuniversity.calculateTotalPowerOfACharacter(clanName, characterName));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			menu(0);
		}else if(option == 13) {
			long t1 = System.nanoTime();
			happyuniversity.closeAndSavefileCreator();
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Ejecucion: "+save );
			System.out.println("BAI BAI!");
		}else if(option == 14) {
			System.out.println("No guarde");
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
		System.out.println("9.  Aniadir una tecnica a un personaje");
		System.out.println("10. Mostar tecnicas de un personaje");																												
		System.out.println("11. Eliminar una tecnica");
		System.out.println("12. Calcular poder total de un personaje");
		System.out.println("13. Salvar cambios y cerrar programa");
		System.out.println("14. Salir sin guardar cambios");
	
		
		
		
	}


}
