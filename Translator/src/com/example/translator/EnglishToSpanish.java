package com.example.translator;

import java.util.ArrayList;
import java.util.List;

public class EnglishToSpanish {
	
	// Field to hold String Arrays
	private List<String []> dictionary;
	
	// Constructor
	public EnglishToSpanish () {
		
		// Initialize dictionary List
		dictionary = new ArrayList<String []>(0);
		
		// Add some words to the dictionary
		addEntry("this", "esta");
		addEntry("dog", "perro");
		addEntry("is", "es");
		addEntry("a", "un");
		addEntry("father", "padre");
		addEntry("mother", "madre");
		addEntry("kitchen", "cocina");
		addEntry("in", "en");
		addEntry("the", "el");
		addEntry("with", "con");
		
	} // end constructor
	
	// Adds words to the dictionary List
	public void addEntry(String e, String s) {
		String entry [] = {e, s};
		dictionary.add(entry);
	} // end addEntry
	
	// Returns the dictionary object
	public List <String []> getDictionary() {
		return dictionary;
	} // end getDictionary

}
