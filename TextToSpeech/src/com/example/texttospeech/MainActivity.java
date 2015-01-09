package com.example.texttospeech;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import android.text.Editable;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
	// XML Objects
	private Button speak;
	private EditText enterText;
	private Button buttonLow;
	private Button buttonHigh;
	
	// Variable to store text for speaking
	private String phrase;
	
	// Text to speech object
	private TextToSpeech speaker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Bind XML objects
		speak = (Button)findViewById(R.id.speechButton);
		enterText = (EditText)findViewById(R.id.enterText);
		buttonLow = (Button)findViewById(R.id.buttonLow);
		buttonHigh = (Button)findViewById(R.id.buttonHigh);
		
		// Initialize text to speech object
		speaker = new TextToSpeech(this, this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
	
	//speak function by the button
	public void speak(View v) {
		speaker.setPitch(0);
		
		// Get input text
		Editable input = enterText.getText();
		
		// Convert input text into a String
		phrase = input.toString();
		
		//Speaking the phrase aloud
		speaker.speak(phrase, 1, null);
		
	}
	
	public void handleClick(View v) {
		
		switch (v.getId()) {
			case R.id.buttonEnglish:
				speaker.setLanguage(Locale.ENGLISH);
				break;
			case R.id.buttonFrench:
				speaker.setLanguage(Locale.FRENCH);
				break;
			case R.id.buttonGerman:
				speaker.setLanguage(Locale.GERMAN);
				break;
			case R.id.buttonItalian:
				speaker.setLanguage(Locale.ITALIAN);
				break;
			case R.id.buttonLow:
				speaker.setPitch(1);
				break;
			case R.id.buttonHigh:
				speaker.setPitch(2);
				break;
				
		}
	}
	
	
}
















