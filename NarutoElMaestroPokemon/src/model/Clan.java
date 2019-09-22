package model;

public class Clan extends ComparatorName{
	
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
	public void addCharacterToTheList(String name, String personality, String creationDate, int powerAbility) throws thatNameIsUsedNowException {
		validateAvaiableNameForCharacter(name);
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
	public String deleteCharacterOfTheList(String name) throws noCharacterFindedException {
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
			newReference = newReference.getNext();
		}
		if(msg == "") {
			throw new noCharacterFindedException("Error!");
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
	public String showCharacters() {
		NarutoCharacter newReference = first;
		String msg = "";
		while(newReference != null) {
			msg += newReference.toString();	
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
	private void validateAvaiableNameForCharacter(String name) throws thatNameIsUsedNowException{
		NarutoCharacter newReference = first;
		NarutoCharacter info = null;
		boolean centinel = false;
		while(newReference != null && centinel == false) {
			if(newReference.getName().equals(name)) {
				centinel = true;
				throw new thatNameIsUsedNowException("Error!");	
			}
			newReference = newReference.getNext();
		}	
	}
	public String changeCharacterInfo(String currentName, String newCharacterName, String personality, int powerAbility, String creationDate) throws noCharacterFindedException, thatNameIsUsedNowException {
		String msg = "";
		NarutoCharacter characterNaruto = searchNarutoCharacter(currentName);
		validateAvaiableNameForCharacter(newCharacterName);
		msg =  characterNaruto.toString();
		characterNaruto.setName(newCharacterName);
		characterNaruto.setPersonality(personality);
		characterNaruto.setPowerAbility(powerAbility);
		characterNaruto.setCreationDate(creationDate);
		return msg;
	}
	public String addTechniquetoACharacter(String characterName, String techniqueName, int influenceFactor) throws noCharacterFindedException {
		String msg = "";
		NarutoCharacter characterNaruto = searchNarutoCharacter(characterName);
		characterNaruto.addTechniqueToTheList(techniqueName, influenceFactor);
		msg = characterNaruto.toString();
		return msg;
	}
	public String showCharacterTechniques(String characterName) throws noTechniqueFindedException, noCharacterFindedException {
		String msg = "";
		NarutoCharacter characterNaruto = searchNarutoCharacter(characterName);
		msg = characterNaruto.showCharacterTechniques();
		return msg;
	}
	public String deleteCharacterTechnique(String characterName, String characterTechnique) throws noCharacterFindedException, noTechniqueFindedException {
		String msg = "";
		NarutoCharacter characterNaruto = searchNarutoCharacter(characterName);
		msg = characterNaruto.generalDeleteOfTechnique(characterTechnique);
		return msg;
	}
	public int calculateTotalPowerOfThecharacter(String characterName) throws noCharacterFindedException, noTechniqueFindedException {
		int power = 0;
		NarutoCharacter characterNaruto = searchNarutoCharacter(characterName);
		int defaultPower = characterNaruto.getPowerAbility();
		int parcialPower = characterNaruto.totalPowerOfTheCharacter();
		int totalPower = defaultPower*parcialPower;
		return totalPower;
		
	}
	public String organizeListWithBubble() {
		String msg = "SALI";
		int movement = 0;
		NarutoCharacter newPrevius = null;
		NarutoCharacter newNext = null;
		NarutoCharacter oToOrganize = first;
		ComparatorName compareName = new ComparatorName();
		int bigger = 0;
		while(oToOrganize != null ) {
			System.out.println("Bucle en el while no puedo salir");
			newNext = oToOrganize.getNext();
			newPrevius = oToOrganize.getPrevius();
			if(newPrevius != null && newNext != null) {
				bigger = compareName.compare(newPrevius, oToOrganize);
				System.out.println("Falla en el primer if");
				if(bigger > 0) {
					first = oToOrganize;
					oToOrganize.getPrevius().setNext(oToOrganize.getNext());
					oToOrganize.getPrevius().setPrevius(oToOrganize);
					oToOrganize.getNext().setPrevius(oToOrganize.getPrevius());
					
					/*
					newPrevius.setNext(oToOrganize.getNext());
					newPrevius.setPrevius(oToOrganize);
					newNext.setPrevius(oToOrganize.getPrevius());
					oToOrganize.setNext(oToOrganize.getPrevius());
					oToOrganize.setPrevius(null);
					*/
					System.out.println("Falla en el segundo if");			
				}
			}
			/*
			else if(newPrevius == null && newNext == null) {
				bigger = compareName.compare(newPrevius, oToOrganize);
				if(bigger > 0) {
					first = oToOrganize;
				}
			}
			*/
			else if(newPrevius == null && newNext != null) {
				bigger = compareName.compare(oToOrganize, newNext);
				if(bigger > 0) {
					first = newNext;
					newNext.getPrevius().setNext(newNext.getNext());
					newNext.getPrevius().setPrevius(newNext);
					newNext.getNext().setPrevius(newNext.getPrevius());
					
				}
			}
		oToOrganize = oToOrganize.getNext();
		}
		return msg;
	}
	
	//cual es la estrategia para encontar en anterior en una lista siple enlazada
	//como diferencio todos los metodos de recorrido se me olvidan siempre que los voy a hacer
	//como hago los test
}
