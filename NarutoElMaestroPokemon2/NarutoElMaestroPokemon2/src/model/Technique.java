package model;

import java.io.Serializable;

public class Technique implements Comparable<Technique> , Serializable{
	private String name;
	private int influenceFactor;
	private Technique next;	
	public Technique(String name, int influenceFactor) {
		super();
		this.name = name;
		this.influenceFactor = influenceFactor;
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInfluenceFactor() {
		return influenceFactor;
	}
	public void setInfluenceFactor(int influenceFactor) {
		this.influenceFactor = influenceFactor;
	}
	public Technique getNext() {
		return next;
	}
	public void setNext(Technique next) { 
		this.next = next;
	}
	public int compareTo(Technique technique) {
		return technique.getName().compareTo(name);
	}
	@Override
	public String toString() {
		return "Technique [name=" + name + ", influenceFactor=" + influenceFactor + "]";
	}
	
	
}
