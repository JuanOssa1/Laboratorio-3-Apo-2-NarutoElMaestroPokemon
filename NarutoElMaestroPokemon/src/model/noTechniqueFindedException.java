package model;

public class noTechniqueFindedException extends Exception{
	public noTechniqueFindedException(String moltenCoreWarning) {
		super(moltenCoreWarning);
	}
}

