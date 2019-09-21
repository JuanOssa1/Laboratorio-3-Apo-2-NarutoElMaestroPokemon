package model;

import java.util.ArrayList;

public class University {
	
	private ArrayList<Clan> clans;
	private ComparatorName namers;
	
	
	public University() {
		clans = new ArrayList<Clan>();	
	}
	public void validateAvailabilityOfTheName(String name) throws thatNameIsUsedNowException {
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
	public Clan searchClan(String name) throws noClanFindedException {
		Clan askedclan = null;
		for (int i = 0; i < clans.size(); i++) {
			if(clans.get(i).getName().equals(name)) {
				 askedclan = clans.get(i);
			}else if(askedclan == null) {
				throw new noClanFindedException("Error!");
			}
		}
		return askedclan;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void searchClanToAddCharacter(String name, String Charactername, String personality, String creationDate, int powerAbility) {
		String msg = "";
		Clan askedclan;
		try {
			askedclan = searchClan(name);
			askedclan.addCharacterToTheList(Charactername, personality, creationDate, powerAbility);
		} catch (noClanFindedException e) {
			msg = "No existe clan con ese criterio";
		}
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String searchClanToAddTecniquesToACharacter(String name, String techniqueName,String abilityName, int influenceFactor){
		String msg = "";
		Clan askedclan = null;
		try {
			askedclan = searchClan(name);
		} catch (noClanFindedException e1) {
			msg = "Ese clan no existe";
		}
		try {
			askedclan.addTechniqueToACharacter(techniqueName, abilityName, influenceFactor);
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
}
