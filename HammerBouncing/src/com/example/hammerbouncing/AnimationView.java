package com.example.hammerbouncing;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	
	// Create some Actors
	private Actor joshua;
	private Actor rebecca;
	private Actor devin;
	private Actor bob;
	private Actor kendall;
	private Actor jeff;
	private Actor twitter;
	private Actor usdoj;
	
	// Breakout Actors
	private Actor paddle;
	private Actor ball;
	
	// Array for Bricks
	private List <Actor> bricks;
	
	// Values to hold the Accel Data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	// Create the Handler for Animation
	private Handler h;
	private int RATE = 30; // About 30 fps
	

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		// Breakout Actor Constructor
		paddle = new Actor(context, 300, 300, Color.RED, 40);
		ball = new Actor(context, 200, 200, Color.BLUE, 25);
		
		paddle.setWidth(150);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		bricks = new ArrayList <Actor> (0); // Creates a list of 6
		
		// For Loop to initialize bricks as Actors (create 6)
		for (int i = 0; i < 6; i++) {
			bricks.add(new Actor(context, i*80, 100, Color.GREEN, 40));
		}
		
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).setWidth(75);
		}

		
		//Initialize the Actors
//		joshua = new Actor(context, 100, 100, Color.RED, 10);
//		rebecca = new Actor(context, 200, 200, Color.BLUE, 20);
//		devin = new Actor(context, 300, 300, Color.CYAN, 30);
//		bob = new Actor(context, 400, 400, Color.GREEN, 40);
//		kendall = new Actor(context, 500, 500, Color.MAGENTA, 50);
//		jeff = new Actor(context, 600, 600, Color.YELLOW, 60);
//		twitter = new Actor(context, 50, 50, Color.CYAN, 70);
//		twitter.setCostume(R.drawable.twittericon);
//		usdoj = new Actor(context, 20, 20, Color.RED, 80);
//		usdoj.setCostume(R.drawable.usdoj);
//		
//		joshua.setDX(5);
//		joshua.setDY(5);
//		
//		rebecca.setDX(10);
//		rebecca.setDY(-10);
//		
//		devin.setDX(3);
//		devin.setDY(-3);
//		
//		bob.setDX(12);
//		bob.setDY(7);
//		
//		kendall.setDX(15);
//		kendall.setDY(15);
//		
//		jeff.setDX(7);
//		jeff.setDY(-12);
//		
//		twitter.setDX(20);
//		twitter.setDY(20);
//		
//		usdoj.changeDX(-30);
//		usdoj.changeDY(30);
		
		//Initial the Handler
		h = new Handler();		
		
	} // End constructor
	
	// onDraw method - in all View classes
	public void onDraw(Canvas c) {
		// Breakout Actors
		paddle.drawRect(c);
		ball.drawCircle(c);
		
		ball.move();
		ball.bounce(c);
		if(ball.isTouching(paddle)) {
			ball.bounceUp();
		}
		
		// Bricks Draw Rectangles - in onDraw()
		for (int i = 0; i < bricks.size(); i++) {
			// Set Brick Width for screen
			bricks.get(i).setWidth((c.getWidth()/6)-3);
			// Set the x position for the bricks
			int xPos = i * (c.getWidth()/6);
			// goTo and Draw the Bricks
			bricks.get(i).goTo(xPos, 100);
			bricks.get(i).drawRect(c);
			
			// Check for Collisions and Erase Bricks
			if (ball.isTouching(bricks.get(i))) {
				if (bricks.get(i).getVisable() == true) {
					ball.bounceUp();
					bricks.get(i).setVisable(false);
				} // end if
			} // end if
		} // end For Loop for bricks

//		joshua.drawCircle(c);
//		rebecca.drawSquare(c);
//		devin.drawSquare(c);
//		bob.drawSquare(c);
//		kendall.drawCircle(c);
//		jeff.drawCircle(c);
//		twitter.draw(c);
//		usdoj.draw(c);
		
		// Bounce off the usdoj Actor
//		if(twitter.isTouching(devin)) {
//			twitter.bounceOff();
//		}
//		
		// Actors move
//		joshua.move();
//		rebecca.move();
//		devin.move();
//		bob.move();
//		kendall.move();
//		jeff.move();
//		twitter.move();
//		usdoj.move();
//		
//		joshua.bounce(c);
//		rebecca.bounce(c);
//		devin.bounce(c);
//		bob.bounce(c);
//		kendall.bounce(c);
//		jeff.bounce(c);
//		twitter.bounce(c);
//		usdoj.bounce(c);
		
		// Call the Runnable
		h.postDelayed(r, RATE);
		
	}
	
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			invalidate();
		}
		
	};
	
	// Function to Grab touch event data
	public boolean onTouchEvent(MotionEvent event) {
		// Fetch data from touch event
		int action = event.getActionMasked(); // get type of action
		int actionIndex = event.getActionIndex(); // get index of action
		
		// set Position of Devin to touch data
//		devin.goTo((int)event.getX(), (int)event.getY());
		paddle.goTo((int)event.getX(), 750);
		
		return true;
	} // end onTouchEvent
	
	//Modifier fields for acceleration data on x, y, & z
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	

} // End class AnimationView










