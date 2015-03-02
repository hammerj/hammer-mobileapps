package com.example.currencyhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Tips extends Activity {
	private SeekBar seekBar;
	private TextView textSeek;
	private TextView textTip;
	private TextView textTotal;
	private EditText editMoney;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tips);
		seekBar = (SeekBar)findViewById(R.id.seekBar);
		textSeek = (TextView)findViewById(R.id.textSeek);
		textTip = (TextView)findViewById(R.id.textTip);
		textTotal = (TextView)findViewById(R.id.textTotal);
		editMoney = (EditText)findViewById(R.id.editMoney);
		
		seekBar.setMax(100);
		seekBar.setProgress(6);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_tips);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tips, menu);
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
	
	private OnSeekBarChangeListener seekBarListener =
			new OnSeekBarChangeListener () {

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
					int percent = seekBar.getProgress();
					String percentString = String.valueOf(percent);
					textSeek.setText(percentString);
					textTip.setText(getTip(percent));
					
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
		
	};
	
	public void handleClick(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	private String getTip(int percent) {
		double bill = Double.valueOf(editMoney.getText().toString());
		double tip = bill * (Double.valueOf(percent)/100);
		String tipString = String.valueOf(tip);
		
		textTotal.setText(String.valueOf(bill + tip));
		
		return tipString;
	}
	
}







