package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.Clan;
import model.NarutoCharacter;
import model.thatNameIsUsedNowException;

public class testClan {
	private Clan clan;
	
	
	
	private void setUpSceneOrganize() throws thatNameIsUsedNowException {
		clan = new Clan("opa");
		//NarutoCharacter tmp =null;
		clan.addCharacterToTheList("1", "sdsd", "12/12/12", 12);
		clan.addCharacterToTheList("0", "sd", "12/12/12", 12);
		clan.addCharacterToTheList("5", "sdd", "12/12/12", 12);
		
		//clan.organizeListWithBubble();
	}
	@Test
	public void testSceneOrganizeWithBubble() throws thatNameIsUsedNowException {
		setUpSceneOrganize();
		clan.organizeListWithBubble();
		assertEquals(clan.showCharacters(),"Character [name=0, personality=sd, creationDate=12/12/12, powerAbility=12]Character [name=1, personality=sdsd, creationDate=12/12/12, powerAbility=12]Character [name=5, personality=sdd, creationDate=12/12/12, powerAbility=12]");
	}
	private void setUpSceneOrganizeFirstNotNull() throws thatNameIsUsedNowException {
		clan = new Clan("opa");
		//NarutoCharacter tmp =null;
		clan.addCharacterToTheList("0", "sdsd", "12/12/12", 12);
		clan.addCharacterToTheList("2", "sd", "12/12/12", 12);
		clan.addCharacterToTheList("1", "sdd", "12/12/12", 12);
		
		//clan.organizeListWithBubble();
	}
	@Test
	public void testSceneOrganizeFirstNotNull() throws thatNameIsUsedNowException {
		setUpSceneOrganizeFirstNotNull();
		clan.organizeListWithBubble();
		assertEquals(clan.showCharacters(),"Character [name=0, personality=sdsd, creationDate=12/12/12, powerAbility=12]Character [name=1, personality=sd, creationDate=12/12/12, powerAbility=12]Character [name=2, personality=sdd, creationDate=12/12/12, powerAbility=12]");
	}
}
