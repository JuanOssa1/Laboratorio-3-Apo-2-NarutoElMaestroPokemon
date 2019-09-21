package model;

public class NarutoCharacter {
	private String name;
	private String personality;
	private String creationDate;
	private int powerAbility;
	private Technique first;
	private NarutoCharacter next;
	private NarutoCharacter previus;
	public NarutoCharacter(String name, String personality, String creationDate, int powerAbility) {
		super();
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.powerAbility = powerAbility;
		this.next = next;
		this.previus = previus;
		this.first = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getPowerAbility() {
		return powerAbility;
	}
	public void setPowerAbility(int powerAbility) {
		this.powerAbility = powerAbility;
	}
	
	public NarutoCharacter seeNextObject() {
		return this.next;
	}
	public void addCharacter(NarutoCharacter character) {
		this.next = character;
	}
	
	public NarutoCharacter getNext() {
		return next;
	}
	public void setNext(NarutoCharacter next) {
		this.next = next;
	}
	public NarutoCharacter getPrevius() {
		return previus;
	}
	public void setPrevius(NarutoCharacter previus) {
		this.previus = previus;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", personality=" + personality + ", creationDate=" + creationDate
				+ ", powerAbility=" + powerAbility + "]";
	}
	public Technique createTechnique(String name, int influenceFactor) {
		Technique tech = new Technique(name, influenceFactor);
		return tech;
	}
	public void addTechniqueToTheList(String name, int influenceFactor) {
		Technique tech = createTechnique( name,  influenceFactor);
		if(first == null) {	
			first = tech;
		}else {
			Technique newReference = first;
			while(newReference.getNext()!=null) {
				newReference = newReference.getNext();
			}
			newReference = newReference.getNext();
		}
	}
	public void deleteWhennextAreNull(String name) {
		Technique tech = first;
		first = null;
	}
	public void deleteWhennextAreNotNull(String name) throws noTechniqueFindedException {
		Technique tech = first;
		String msg = "";
		Technique tmp = null;
		while(tech != null) {
			if(tech.getName().equals(name)) {
				msg = tech.toString();
				tmp = tech.getNext();
				first.setNext(tmp);
			}
			tech = tech.getNext();
		}
		if(tech == null) {
			throw new noTechniqueFindedException("Error!");
		}
	}
	public void generalDeleteOfTechnique(String name) throws noTechniqueFindedException {
		Technique tech = first;
		Technique tmp = null;
		while(tech != null) {
			if(tech.getName().equals(name)) {
				if(tech.getNext() != null) {
					deleteWhennextAreNotNull(name);
				}else if(tech.getNext() == null) {
					deleteWhennextAreNull(name);
				}
			}
			tech = tech.getNext();
		}
		if(tech== null) {
			throw new noTechniqueFindedException("Error!");
		}
	}
	public String showCharacterTechniques() {
		Technique tech = first;
		String msg = "";
		while(tech != null) {
			msg +=tech.toString();
			tech = tech.getNext();
		}
		return msg;
	}
	
}
