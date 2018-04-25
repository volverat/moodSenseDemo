package com.example.moodsense.model;

/**
 * @author victor olvera
 * Types of Moods
 */
public enum Mood {
	HAPPY(1),
	SAD(2),
	NEUTRO(3),
	UNKNOWN(0);
	
	//Field
	private int id;
	
	//Constructor 
	Mood(int id){
		this.id = id;
	}
	
	//Methods
	
	//Return a Mood based on his id
	public static Mood getMoodFromId(int id) {
		for (Mood mood : Mood.values()) {
			if(mood.id == id) {
				return mood;
			}
		}
		return UNKNOWN;
	}
	
}
