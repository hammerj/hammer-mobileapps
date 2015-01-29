package com.example.countdown;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Fields
	private TextView textTimer;
	private Button resetButton;
	private Button buttonResume;
	private Button buttonPause;
	boolean isRunning = true;
	
	// For the Handler / Runnable
	private int elapsedTime; // Hold the time that has passed
	
	private Handler h; // The Handler
	
	private int RATE = 1000; // Milliseconds - how fast

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Bind the XML
		textTimer = (TextView)findViewById(R.id.textTimer);
		resetButton = (Button)findViewById(R.id.resetButton);
		buttonResume = (Button)findViewById(R.id.buttonResume);
		buttonPause = (Button)findViewById(R.id.buttonPause);
		
		// Initialize the counters
		elapsedTime = 61; // Sets variable to 60
		
		h = new Handler(); // Initializes the Handler
		
		count();
		
		
	}
	
	public void reset(View v) {
		elapsedTime = 61;
	}

	public void count() {
		elapsedTime--; // elapsedTime = elapsedTime - 1;
		textTimer.setText(String.valueOf(elapsedTime));
		if(elapsedTime < 1) {
			isRunning = false;
		}
		if(isRunning == true) {
			h.postDelayed(r, RATE);
		} // End if statement
	} // End count()
	
	public void pause(View v) {
		isRunning = false;
	}
	
	public void resume (View v) {
		isRunning = true;
		count();
	}
	
	// Define the Runnable - calls the count() function
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			count(); // call back the count function
			
		}
		
		
	}; // End Runnable

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
}
