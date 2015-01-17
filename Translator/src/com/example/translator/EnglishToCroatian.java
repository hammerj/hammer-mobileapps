package com.example.translator;

import java.util.ArrayList;
import java.util.List;

public class EnglishToCroatian {
	
	// Field to hold String Arrays
	private List<String []> dictionaryc;
	
	// Constructor
	public EnglishToCroatian () {
			
		// Initialize dictionary List
		dictionaryc = new ArrayList<String []>(0);
			
		// Add some words to the dictionary
		addEntry("this", "ovo");
		addEntry("dog", "pas");
		addEntry("is", "je");
		addEntry("a", "nekakav");
		addEntry("father", "otac");
		addEntry("mother", "majka");
		addEntry("kitchen", "kuhinja");
		addEntry("in", "u");
		addEntry("the", "the");
		addEntry("with", "s");
			
	} // end constructor
		
	// Adds words to the dictionary List
	public void addEntry(String e, String c) {
		String entry [] = {e, c};
		dictionaryc.add(entry);
	} // end addEntry
	
	// Returns the dictionary object
	public List <String []> getDictionary() {
		return dictionaryc;
	} // end getDictionary

}
