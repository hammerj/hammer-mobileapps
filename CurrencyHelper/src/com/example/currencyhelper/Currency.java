package com.example.currencyhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Currency extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_currency);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.currency, menu);
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
		boolean checked = ((RadioButton) v).isChecked();
		
		EditText editAmount = (EditText)findViewById(R.id.editAmount);
		double amount = 0;
		
		if(editAmount.length() > 0) {
			amount = Double.parseDouble(String.valueOf(editAmount.getText()));
		}
		
		switch (v.getId()) {
		case R.id.radioDollars:
			if (checked) {
				String dollars = usdToHKD(amount);
				editAmount.setText(dollars);
			}
			break;
			
		case R.id.radioHKD:
			if (checked) {
				String hkd = hkdToUSD(amount);
				editAmount.setText(hkd);
			}
			break;
		}
	}
	
	private String usdToHKD(double amount) {
		double HKD = (amount / 7.76);
		return String.valueOf(HKD);
	}
	
	private String hkdToUSD(double amount) {
		double USD = (amount * 7.76);
		return String.valueOf(USD);
	}
	
	public void handleClick1(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
}





