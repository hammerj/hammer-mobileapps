package com.example.translator;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.speech.tts.TextToSpeech;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	
	// Define the dictionary field for translations
	private EnglishToSpanish dictionary;
	private EnglishToCroatian dictionaryc;
	
	// Fields for UI
	private EditText editEnglish;
	private EditText editTranslate;
	private Button buttonTranslateWord;
	private Button buttonAddWord;
	private Button buttonPhrase;
	private Button buttonSpeak;
	private Button buttonClear;
	private Button buttonTranslate;
	private Button buttonAdd;
	private Button buttonPhrase2;
	
	private TextToSpeech speaker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initialize the dictionary
		dictionary = new EnglishToSpanish();
		dictionaryc = new EnglishToCroatian();
		
		// Bind  the XML objects
		editEnglish = (EditText)findViewById(R.id.editEnglish);
		editTranslate = (EditText)findViewById(R.id.editTranslate);
		buttonTranslateWord = (Button)findViewById(R.id.buttonTranslateWord);
		buttonAddWord = (Button)findViewById(R.id.buttonAddWord);
		buttonPhrase = (Button)findViewById(R.id.buttonPhrase);
		buttonSpeak = (Button)findViewById(R.id.buttonSpeak);
		buttonClear = (Button)findViewById(R.id.buttonClear);
		buttonTranslate = (Button)findViewById(R.id.buttonTranslate);
		buttonAdd = (Button)findViewById(R.id.buttonAdd);
		buttonPhrase2 = (Button)findViewById(R.id.buttonPhrase2);
		
		
		
		speaker = new TextToSpeech(this, this);
		
	} // end onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Returns a List of words parsed from a String
	public List<String> getParsed(String s) {
		// establish a blank List to return
		List <String> words = new ArrayList<String>(0);
		// Transfer content of s to phrase
		String phrase = s;
		// Convert phrase to lower case
		phrase.toLowerCase();
		// Define current word
		String currentWord = ""; // blank
		// Create an array of char objects from string
		char [] charList = phrase.toCharArray();
		
		// For loop to search for characters and pull out words
		for (int i = 0; i < charList.length; i++) {
			// Is the char not a space
			if (!String.valueOf(charList[i]).equals(" ")) {
				currentWord += String.valueOf(charList[i]); // add letter
			}
			else {
				words.add(currentWord); // put current word in list
				currentWord = ""; // blank out current word
			}
		}
		
		// Check for word at the end
		if (currentWord.length() > 0) {
			words.add(currentWord);
		}
		
		return words;
	} // end endParsed()
	
	// Translates a string of words and returns a string with translation
	public String translate(String s) {
		String result = "";
		
		// Define a blank List
		List<String> words = getParsed(s);
		// Define a list of available translations
		List<String []> bank = dictionary.getDictionary();
		
		// For the words in the list words
		for (int i = 0; i < words.size(); i++) {
			// Search for the match in the bank list
			for (int w = 0; w < bank.size(); w++) {
				if (words.get(i).equals(bank.get(w)[0])) { // Match 
					result += bank.get(w)[1]; // add translated word to result
					result += " "; // add a space
				} // end if
			} // end for
		} // end for
		
		return result;
	} // end translate
	
	// Returns a List of words parsed from a String
		public List<String> getParsed1(String c) {
			// establish a blank List to return
			List <String> words = new ArrayList<String>(0);
			// Transfer content of s to phrase
			String phrase = c;
			// Convert phrase to lower case
			phrase.toLowerCase();
			// Define current word
			String currentWord = ""; // blank
			// Create an array of char objects from string
			char [] charList = phrase.toCharArray();
			
			// For loop to search for characters and pull out words
			for (int i = 0; i < charList.length; i++) {
				// Is the char not a space
				if (!String.valueOf(charList[i]).equals(" ")) {
					currentWord += String.valueOf(charList[i]); // add letter
				}
				else {
					words.add(currentWord); // put current word in list
					currentWord = ""; // blank out current word
				}
			}
			
			// Check for word at the end
			if (currentWord.length() > 0) {
				words.add(currentWord);
			}
			
			return words;
		} // end endParsed()
	
	// Translates a string of words and returns a string with translation
		public String translate1(String c) {
			String result = "";
			
			// Define a blank List
			List<String> words = getParsed(c);
			// Define a list of available translations
			List<String []> bankc = dictionaryc.getDictionary();
			
			// For the words in the list words
			for (int i = 0; i < words.size(); i++) {
				// Search for the match in the bank list
				for (int w = 0; w < bankc.size(); w++) {
					if (words.get(i).equals(bankc.get(w)[0])) { // Match 
						result += bankc.get(w)[1]; // add translated word to result
						result += " "; // add a space
					} // end if
				} // end for
			} // end for
			
			return result;
		} // end translate
	
	// Functions for button clicks
	// Translate single word (or phrase)
	public void buttonTranslateWordClicked(View v) {
		String eWord = editEnglish.getText().toString();
		String spanishWord = translate(eWord);
		editTranslate.setText(spanishWord);
	}
	
	// Add english / spanish to dictionary
	public void buttonAddWordClicked(View v) {
		String english = editEnglish.getText().toString();
		String spanish = editTranslate.getText().toString();
		dictionary.addEntry(english, spanish);
		editEnglish.setText("");
		editTranslate.setText("");
		editEnglish.requestFocus();		
	} // end buttonAddWordClicked
	
	public void buttonPhraseClicked(View v) {
		String english = editEnglish.getText().toString();
		String spanish = translate(english);
		editTranslate.setText(spanish);
	}
	
	public void buttonTranslateClicked(View v) {
		String eWord = editEnglish.getText().toString();
		String croatianWord = translate(eWord);
		editTranslate.setText(croatianWord);
	}
	
	public void buttonAddClicked(View v) {
		String english = editEnglish.getText().toString();
		String croatian = editTranslate.getText().toString();
		dictionaryc.addEntry(english, croatian);
		editEnglish.setText("");
		editTranslate.setText("");
		editEnglish.requestFocus();
	} // end buttonAddClicked
	
	public void buttonPhrase2Clicked(View v) {
		String english = editEnglish.getText().toString();
		String croatian = translate(english);
		editTranslate.setText(croatian);
	}
	
	public void buttonClearClicked(View v) {
		editEnglish.setText("");
		editTranslate.setText("");
	}
	
	public void buttonSpeakClicked(View v) {
		String english = editEnglish.getText().toString();
		String spanish = translate(english);
		editTranslate.setText(spanish);
		speaker.speak(spanish, 1, null);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
}









