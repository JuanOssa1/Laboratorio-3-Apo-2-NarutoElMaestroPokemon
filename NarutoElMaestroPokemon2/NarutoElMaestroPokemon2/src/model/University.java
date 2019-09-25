package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable{
	public static String SEARCHROUTE ="Charger//clans.dat";
	private ArrayList<Clan> clans;
	private ComparatorName namers;
	
	
	public University() {
		clans = new ArrayList<Clan>();
		startProgramLoadClans();
	}
	
	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}

	private void validateAvailabilityOfTheName(String name) throws thatNameIsUsedNowException {
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).getName().equals(name)) {
				throw new thatNameIsUsedNowException("Error!");
			}
		}
	}
	public String createNewClan(String name ) {
		String msg = ""; 
		try {
			validateAvailabilityOfTheName(name);
			Clan clan = new Clan(name);
			clans.add(clan);
		} catch (thatNameIsUsedNowException e) {
			msg = "Ese nombre de clan no esta disponible";
		}
		
		return msg;
	}
	private Clan searchClan(String name) throws noClanFindedException, theArrayListIsEmptyException {
		Clan askedclan = null;
		if(clans.size() == 0) {
			throw new theArrayListIsEmptyException("Error!");
		}else {
		for (int i = 0; i < clans.size(); i++) {
				if(clans.get(i).getName().equals(name)) {
					askedclan = clans.get(i);
				}
			
			}
			if(askedclan == null) {
				throw new noClanFindedException("Error!");
			}
		}
		return askedclan;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String searchClanToAddCharacter(String name, String Charactername, String personality, String creationDate, int powerAbility) {
		String msg = "";
		Clan askedclan;
		try {
			askedclan = searchClan(name);
			askedclan.addCharacterToTheList(Charactername, personality, creationDate, powerAbility);
		} catch (noClanFindedException e) {
			msg = "No existe clan con ese criterio";
		} catch (thatNameIsUsedNowException e) {
			msg = "Ya hay un personaje con ese nombre";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes";
		}
		return msg;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String searchClanToAddTecniquesToACharacter(String name, String techniqueName,String abilityName, int influenceFactor){
		String msg = "";
		Clan askedclan = null; 
		try {
			askedclan = searchClan(name);
		} catch (noClanFindedException e1) {
			msg = "Ese clan no existe";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes";
		}
		try {
			askedclan.addTechniquetoACharacter(techniqueName, abilityName, influenceFactor);
			msg = "Todo ha funcionado sin problemas";
		} catch (noCharacterFindedException e) {
			msg = "Senior usuario ese personaje no existe";
		}
		return msg;
	}
	public String deleteClan(String name) {
		String msg = "";
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).getName().equals(name)) {
				msg = "El clan eliminado fue"+" "+clans.get(i).toString();
				clans.remove(i);
			}else{
				msg = "Ese clan no existe";
			}
		}
		return msg;
	}
	public String showClans() {
		String askedclan = "";
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i) != null) {
				askedclan += clans.get(i).toString();
			} 
			else if(askedclan == "") {
				askedclan = "No hay clanes para mostar!!!!";
			}
		}
		return askedclan;
	}
	public String changeClanName(String name)  {
		String msg = "";
		try {
			Clan askedClan = searchClan(name);
			validateAvailabilityOfTheName(name);
		} catch (noClanFindedException e) {
			msg = "El clan ingresado no ha sido encontrado";
		} catch (thatNameIsUsedNowException e) {
			msg = "El nombre del clan que quiere cambiar ya es usado";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes";
		}
		return msg;
	}
	public String showCharactersInAClan(String name) {
		String msg = "";
		try {
			Clan askedClan = searchClan(name);
			msg = askedClan.showCharacters();
		} catch (noClanFindedException e) {
			msg = "El clan solicitado aparentemente no existe";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes";
		}
		return msg;
	}
	public String changeCharacterAtributes(String clanName,String currentName, String charactername, String personality, String creationDate, int powerAbility) {
		String msg = "";
		try {
			Clan clanOfTheCharacter = searchClan(clanName);
			msg = clanOfTheCharacter.changeCharacterInfo(currentName, charactername, personality, powerAbility, creationDate);
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes crados";
		} catch (noClanFindedException e){ 
			msg = "En clan aparentemente no existe";
		} catch (noCharacterFindedException e){
			msg = "El nombre del personaje ingresado por parametro no existe";
		} catch (thatNameIsUsedNowException e) {
			msg = "El nombre de ese personaje ya esta usado";
		}
		return msg;
	}
	public String deleteCharacter(String clanName, String name) {
		String msg = "";
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			msg = clanOfTheCharacter.deleteCharacterOfTheList(name);
		} catch (noClanFindedException e) {
			msg = "El clan buscado no existe";
		} catch (theArrayListIsEmptyException e) {
			msg = "No se han agregado clanes todavia";
		} catch (noCharacterFindedException e) {
			msg = "El personaje buscado para eliminar no existe";
		}
	 
		return msg;
	}
	public String addTechniquetoAcharacter(String clanName, String characterName,String techniqueName, int influenceFactor) {
		String msg = "";
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			msg = clanOfTheCharacter.addTechniquetoACharacter(characterName, techniqueName, influenceFactor);
		} catch (noClanFindedException e) {
			msg = "El clan no fue encontrado";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes agregados todavia";
		} catch (noCharacterFindedException e) {
			msg = "No existe un personaje con ese nombre";
		}
		return msg;
	}
	public String showCharacterTechniques(String clanName, String characterName) {
		String msg = "";
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			msg = clanOfTheCharacter.showCharacterTechniques(characterName);
		} catch (noClanFindedException e) {
			msg = "No se ha encontrado ningun clan con ese nombre";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes creados";
		} catch (noTechniqueFindedException e) {
			msg = "No se han encontrado tecnicas en este personaje";
		} catch (noCharacterFindedException e) {
			msg = "No se ha encontrado un personaje con ese nombre";
		}
		return msg;
	}
	public String deleteCharacterTechnique(String clanName, String characterName, String characterTechnique) {
		String msg = "";
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			msg = clanOfTheCharacter.deleteCharacterTechnique(characterName, characterTechnique);
		} catch (noClanFindedException e) {
			msg = "No se ha encontrado ningun clan con ese nombre";
		} catch (theArrayListIsEmptyException e) {
			msg = "No hay clanes creados";
		} catch (noCharacterFindedException e) {
			msg = "No se a encontrado un personaje con ese nombre";
		} catch (noTechniqueFindedException e) {
			msg = "No se ha encontrado una tecnica con ese nombre";
		}
		return msg;
	}
	public int calculateTotalPowerOfACharacter(String clanName, String characterName) {
		int power = 0;
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			power = clanOfTheCharacter.calculateTotalPowerOfThecharacter(characterName);
		} catch (noClanFindedException e) {
			power = 1111111111;
			e.printStackTrace();
		} catch (theArrayListIsEmptyException e) {
			power = 1111111111;
			e.printStackTrace();
		} catch (noCharacterFindedException e) {
			power = 1111111111;
			e.printStackTrace();
		} catch (noTechniqueFindedException e) {
			power = 1111111111;
			e.printStackTrace();
		}
		
		return power;
	}
	public String organizeListOfCharacters(String clanName) {
		String msg = ""; 
		Clan clanOfTheCharacter = null;
		try {
			clanOfTheCharacter = searchClan(clanName);
			clanOfTheCharacter.organizeListWithBubble();
		} catch (noClanFindedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (theArrayListIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg; 
	}
	
	public void closeAndSavefileCreator()  {
		try {
			File fl = new File(SEARCHROUTE);
			ObjectOutputStream duct = new ObjectOutputStream(new FileOutputStream(fl));
			duct.writeObject(clans);
			duct.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void startProgramLoadClans(){
		File file = new File(SEARCHROUTE);
		ArrayList<Clan> p;
		try {
			
				FileInputStream	fi = new FileInputStream(file);
				ObjectInputStream co = new ObjectInputStream(fi);
				p = (ArrayList<Clan>)co.readObject();
				setClans(p); 
				co.close();
			}
			
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public void sortClansWithSelection() {
		ArrayList<Clan> localArrayList = clans;
		for(int i = 0; i < localArrayList.size()-1; i++) {
			int toCompare = i;
			for(int j = i + 1; j < localArrayList.size(); j++) {
				if(localArrayList.get(j).compareTo(o)) {
					
				}
			}
		}
	}
	
	
}
