package com.example.soundsapps;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	//Fields for Image buttons and stop button
	private ImageButton buttonDidgeridoo;
	private ImageButton buttonElectric;
	private ImageButton buttonGuitar;
	private ImageButton buttonPiano;
	private ImageButton buttonTambura;
	private ImageButton buttonTrumpet;
	
	//Stop Button
	private Button buttonStopSounds;
	
	//MediaPlayer Array
	private MediaPlayer soundPlayer [] = new MediaPlayer[6];
	
	private int soundResources [] = {R.raw.didgeridoo, R.raw.guitar, R.raw.spookystring,
										R.raw.suspense, R.raw.tambura,
										R.raw.trumpet};
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Bind the ImageButton Java Objects to the XML resources
		buttonDidgeridoo = (ImageButton)findViewById(R.id.buttonDidgeridoo);
		buttonElectric = (ImageButton)findViewById(R.id.buttonElectric);
		buttonGuitar = (ImageButton)findViewById(R.id.buttonGuitar);
		buttonPiano = (ImageButton)findViewById(R.id.buttonPiano);
		buttonTambura = (ImageButton)findViewById(R.id.buttonTambura);
		buttonTrumpet = (ImageButton)findViewById(R.id.buttonTrumpet);
		
		//Initialize MediaPlayer with resources
		soundPlayer[0] = MediaPlayer.create(this, soundResources[0]);
		soundPlayer[1] = MediaPlayer.create(this, soundResources[1]);
		soundPlayer[2] = MediaPlayer.create(this, soundResources[2]);
		soundPlayer[3] = MediaPlayer.create(this, soundResources[3]);
		soundPlayer[4] = MediaPlayer.create(this, soundResources[4]);
		soundPlayer[5] = MediaPlayer.create(this, soundResources[5]);
		
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
	
	//Functions to play the sounds
	public void buttonDidgeridooClick(View v) {
		soundPlayer[0].start();
	}
	
	public void buttonElectricClick(View v) {
		soundPlayer[2].start();
	}
	
	public void buttonGuitarClick(View v) {
		soundPlayer[1].start();
	}
	
	public void buttonPianoClick(View v) {
		soundPlayer[3].start();
	}
	
	public void buttonTamburaClick(View v) {
		soundPlayer[4].start();
	}
	
	public void buttonTrumpetClick(View v) {
		soundPlayer[5].start();
	}
	
	//Stop all sounds from playing
	public void stopAllSounds(View v) {
		//Iterate through all the sounds
		for (int s = 0; s < soundPlayer.length; s++) {
			//if sound is playing
			if (soundPlayer[s].isPlaying()) {
				soundPlayer[s].pause(); //pause the sound
				soundPlayer[s].seekTo(0); //rewind to the beginning
			} //end if
		} //end for
	} //end function stopAllSounds


}










