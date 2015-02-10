package com.example.hammerintentexercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
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
	
	//Function to switch Intents
	public void handleClick(View v) {
		// Which button was clicked
		switch (v.getId()) {
			case R.id.buttonActivityOne:
				// Create new Intent
				Intent intentOne = new Intent(this, Activity1.class);
				// Start Intent
				startActivity(intentOne);
				break;
			case R.id.buttonActivityTwo:
				// Create new Intent
				Intent intentTwo = new Intent(this, Activity2.class);
				startActivity(intentTwo);
				break;
		} // end Switch
		 // end handleClick
	}
	
}
















