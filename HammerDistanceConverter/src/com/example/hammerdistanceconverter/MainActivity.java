package com.example.hammerdistanceconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	// Method to handle the radio buttons
	public void handleClick(View v) {
		// Boolean object --> which button is checked
		boolean checked = ((RadioButton) v).isChecked();
		
		EditText text1 = (EditText)findViewById(R.id.editDistance);
		double distance = 0;
		
		if(text1.length() > 0) {
			distance = Double.parseDouble(String.valueOf(text1.getText()));
		}
				
		EditText text2 = (EditText)findViewById(R.id.editTemp);
		double temp = 0;
		
		if(text2.length() > 0) {
			temp = Double.parseDouble(String.valueOf(text2.getText()));
		}
		
		// Which button was clicked
		switch (v.getId()) {
		case R.id.radioMiles:
			if (checked) {
				String miles = kmToMiles(distance);
				text1.setText(miles);
			}
			break;
			
		case R.id.radioKilometers:
			if (checked) {
				String kilos = milesToKm(distance);
				text1.setText(kilos);
			}
			break;

		case R.id.radioCelsius:
			if (checked) {
				String celsius = fahrenheitToCelsius(temp);
				text1.setText(celsius);
			}
			break;
				
		case R.id.radioFahrenheit:
			if (checked) {
				String fahrenheit = celsiusToFahrenheit(temp);
				text1.setText(fahrenheit);
			}
			break;
		}
			
	}

	private String celsiusToFahrenheit(double temp) {
		double fahrenheit = (temp * 9 / 5) + 32;
		return String.valueOf(fahrenheit);
	}

	private String fahrenheitToCelsius(double temp) {
		double celsius = (temp - 32) * (5 / 9);
		return String.valueOf(celsius);
	}

	private String milesToKm(double distance) {
		double kilos = distance * 1.609;
		return String.valueOf(kilos);
	}

	private String kmToMiles(double distance) {
		double miles = distance / 1.609;
		return String.valueOf(miles);
	}
	
	public void reset(View v) {
		EditText text1 = (EditText)findViewById(R.id.editDistance);
		EditText text2 = (EditText)findViewById(R.id.editTemp);
		text1.setText("0");
		text2.setText("0");
	}
	
}














