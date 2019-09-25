package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.University;

class testUniversity {
	private University university;

	
	private void setUpSceneSortWithSelection() {
		university = new University();
		university.createNewClan("9");
		university.createNewClan("8");
		university.createNewClan("7");
		university.createNewClan("6");
		university.createNewClan("5");
		university.createNewClan("4");
		university.createNewClan("3");
		university.createNewClan("2");
		university.createNewClan("1");
		university.createNewClan("0");
	}
	@Test
	public void testSceneOrganizeWithSelection() {
		setUpSceneSortWithSelection();
		university.sortClansWithSelection();
		assertEquals(university.showClans(), "Clan "+"[name=0]"+"\n"+"Clan "+"[name=1]"+"\n"+"Clan "+"[name=2]"+"\n"+"Clan "+"[name=3]"+"\n"+"Clan "+"[name=4]"+"\n"+"Clan "+"[name=5]"+"\n"+"Clan "+"[name=6]"+"\n"+"Clan "+"[name=7]"+"\n"+"Clan "+"[name=8]"+"\n"+"Clan "+"[name=9]"+"\n");
	}
	
}
