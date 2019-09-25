package model;

import java.util.Comparator;

public class ComparatorName implements Comparator<NarutoCharacter> {

	@Override
	public int compare(NarutoCharacter clan1, NarutoCharacter clan2) {
		int bigObject = clan1.getName().compareTo(clan2.getName());
		return bigObject;
	}

}
