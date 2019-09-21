package model;

import java.util.Comparator;

public class ComparatorName implements Comparator<Clan> {

	@Override
	public int compare(Clan clan1, Clan clan2) {
		int bigObject = clan1.getName().compareTo(clan2.getName());
		return bigObject;
	}

}
