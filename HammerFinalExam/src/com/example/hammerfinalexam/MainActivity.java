package com.example.hammerfinalexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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
	
	public void handleClick(View v) {
		EditText editDollars = (EditText)findViewById(R.id.editDollars);
		double amount = 0;
		
		EditText editYen = (EditText)findViewById(R.id.editYen);
		double amount1 = 0;
		
		EditText editPounds = (EditText)findViewById(R.id.editPounds);
		double amount2 = 0;
		
		if(editDollars.length() > 0) {
			amount = Double.parseDouble(String.valueOf(editDollars.getText()));
		}
		
		if(editYen.length() > 0) {
			amount1 = Double.parseDouble(String.valueOf(editYen.getText()));
		}
		
		if(editPounds.length() > 0) {
			amount2 = Double.parseDouble(String.valueOf(editPounds.getText()));
		}
		
		switch (v.getId()) {
			case R.id.buttonUSD:
				String dollars = usdToUSD(amount);
				editDollars.setText(dollars);
			case R.id.buttonYen:
				String yen = usdToYen(amount);
				editYen.setText(yen);
			case R.id.buttonPounds:
				String pounds = usdToPounds(amount);
				editPounds.setText(pounds);
		} 
	}
	
	private String usdToUSD(double amount) {
		double USD = (amount * 1);
		return String.valueOf(USD);
	}
	
	private String usdToYen(double amount1) {
		double Yen = (amount1 * 97.35);
		return String.valueOf(Yen);
	}
	
	private String usdToPounds(double amount2) {
		double Pounds = (amount2 * 0.62);
		return String.valueOf(Pounds);
	}
}












