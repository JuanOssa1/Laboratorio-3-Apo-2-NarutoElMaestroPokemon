package model;

public class Character {
	private String name;
	private String personality;
	private String creationDate;
	private int powerAbility;
	private Character next;
	private Character previus;
	public Character(String name, String personality, String creationDate, int powerAbility) {
		super();
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.powerAbility = powerAbility;
		this.next = null;
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
	
	public Character seeNextObject() {
		return this.next;
	}
	public void addCharacter(Character character) {
		this.next = character;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", personality=" + personality + ", creationDate=" + creationDate
				+ ", powerAbility=" + powerAbility + "]";
	}
	
}
