package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.NarutoCharacter;
import model.noTechniqueFindedException;


import model.Clan;
import model.NarutoCharacter;
import model.thatNameIsUsedNowException;
class testNarutoCharacter {
	private NarutoCharacter naru;
	
	public void setUpOrganize() throws noTechniqueFindedException {
		naru = new NarutoCharacter("1", "Bakano", "12/12/12", 1333 );
		naru.addTechniqueToTheList("1", 122);
		naru.addTechniqueToTheList("0", 122);
		naru.addTechniqueToTheList("5", 122);
		
		
	}
	@Test
	public void testOrganize() throws noTechniqueFindedException {
		setUpOrganize();
		naru.organizeTechniques();
		assertEquals(naru.showCharacterTechniques(), 1);
	}

}
