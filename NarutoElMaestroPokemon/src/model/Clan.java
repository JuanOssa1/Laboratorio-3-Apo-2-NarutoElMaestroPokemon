package model;

public class Clan {
	
	private String name;
	private int tamanio;
	private NarutoCharacter first;
	
	public Clan(String name) {
		super();
		this.name = name;
		first = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public NarutoCharacter getFirst() {
		return first;
	}
	public void setFirst(NarutoCharacter first) {
		this.first = first;
	}
	@Override
	public String toString() {
		return "Clan [name=" + name + "]" + "\n";
	}
	/*
	public 	NarutoCharacter createCharacter(String name, String personality, String creationDate, int powerAbility) {
		NarutoCharacter naru = new NarutoCharacter(name, personality, creationDate, powerAbility);
		return naru;
	}
	*/
	public void addCharacterToTheList(String name, String personality, String creationDate, int powerAbility) {
		NarutoCharacter naru = new NarutoCharacter(name, personality, creationDate, powerAbility);
		if(first == null) {	
			first = naru;
		}else {
			NarutoCharacter newReference = first;
			while(newReference.getNext()!=null) {
				newReference = newReference.getNext();
			}
			newReference.setNext(naru);
			naru.setPrevius(newReference);
		}
	}
	public String deleteCharacterOfTheList(String name) {
		NarutoCharacter newReference = first;
		NarutoCharacter before = null;
		NarutoCharacter after = null;
		String msg = "";
		//NarutoCharacter temporalCharacter = null;
		while(newReference != null) {
			if(newReference.getName().equals(name)) {
				
				msg = newReference.toString();
				before = newReference.getPrevius();
				after = newReference.getNext();
				if(before != null && after != null) {
					before.setNext(after);
					after.setPrevius(before);
				}
				else if(before == null && after == null) {
					afterAndBeforeAreNull(newReference);
				}
				else if(before != null && after == null) {
					afterAreNull(newReference);
				}
				else if(before == null && after != null) {
					beforeAreNull(newReference);
				}
			}
			else {
				msg = "No hay nada de lo que me pides";
			}
			newReference = newReference.getNext();
		}
		return msg;
	}
	private String afterAndBeforeAreNull(NarutoCharacter nCharacter) {
		NarutoCharacter newReference = nCharacter;
		String msg ="Eliminado:"+" "+newReference.toString();
		newReference = null;
		return msg;
	}
	private String afterAreNull(NarutoCharacter nCharacter) {
		NarutoCharacter newReference = nCharacter;
		String msg = "Eliminado:"+ " "+newReference.toString();
		NarutoCharacter newReferenceCharacter = newReference.getPrevius();
		first = newReferenceCharacter;
		first.setNext(null);
		return msg;
	}
	private String beforeAreNull(NarutoCharacter nCharacter) {
		NarutoCharacter newReference = nCharacter;
		String msg = "Eliminado:"+ " "+newReference.toString();
		NarutoCharacter newReferenceCharacter = newReference.getNext();
		first = newReferenceCharacter;
		first.setPrevius(null);
		return msg;
	}
	
	public String searchPokemonNaruto(String name) {
		NarutoCharacter newReference = first;
		String msg = "";
		boolean centinel = false;
		while(newReference != null && centinel == false) {
			if(newReference.getName().equals(name)) {
				msg = newReference.toString();
				centinel = true;
			}
			newReference = newReference.getNext();
		}
		if(msg == "") {
			msg = "No encontre nada!";
		}
		return msg;
	}
	public String updatePokemonNarutoData(String name, String personality, String creationDate, int powerAbility) {
		NarutoCharacter characterToUpdate = first;
		String msg = "";
		boolean centinel = false;
		while(characterToUpdate != null && centinel == false) {
			if(characterToUpdate.getName().equals(name)) {
				msg ="El personaje actualizado fue:"+" "+ characterToUpdate.toString();
				characterToUpdate.setCreationDate(creationDate);
				characterToUpdate.setPersonality(personality);
				characterToUpdate.setName(name);
				characterToUpdate.setPowerAbility(powerAbility);
			}
			characterToUpdate = characterToUpdate.getNext();
		}
		return msg;
	}
	public void organizeNarutoCharacter() {
		NarutoCharacter newReference = first, previous = null, next = null;
		while(newReference != null) {	
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private NarutoCharacter searchNarutoCharacter(String name) throws noCharacterFindedException {
		NarutoCharacter newReference = first;
		NarutoCharacter info = null;
		boolean centinel = false;
		while(newReference != null && centinel == false) {
			if(newReference.getName().equals(name)) {
				info = newReference;
				centinel = true;
			}
			newReference = newReference.getNext();
		}
		if(info == null) {
			throw new noCharacterFindedException("Error");
		}
		return info;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String addTechniqueToACharacter(String name,String abilityName, int influenceFactor) throws noCharacterFindedException {
		NarutoCharacter characterN = searchNarutoCharacter(name);
		characterN.addTechniqueToTheList(abilityName, influenceFactor);
		return "";
	}
	
	//cual es la estrategia para encontar en anterior en una lista siple enlazada
	//como diferencio todos los metodos de recorrido se me olvidan siempre que los voy a hacer
	//como hago los test
}
