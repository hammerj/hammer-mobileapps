package com.example.hammerbouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
	// Fields for the Actor
	private Point p; // Location
	private int c; // Color
	private int s; // Size
	private int dx; // Change in x speed
	private int dy; // Change in y speed
	private Paint paint; // Paint object
	
	// ints for wdith and height
	private int w; // width
	private int h; // height
	
	// boolean is visable to check if draw
	private boolean isVisable = true;
	
	// Context
	private Context aContext;
	private int costume;
	private BitmapDrawable graphic;
	
	// Constructor
	public Actor(Context context, int x, int y, int col, int size) {
		// Initialize values
		p = new Point (x, y);
		c = col; // Color
		s = size; // Assigns size
		w = s; // set width
		h = s; // set height
		paint = new Paint(); // Creates Paint object
		paint.setColor(c); // Sets Paint color
		dx = 0; // Sets x speed to 0
		dy = 0; // Sets y speed to 0	
		
		// Set the Context
		aContext = context;
		
	} // End Constructor
	
	// Accessors and Modifiers (Getters and Setters)
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	public int getSize() {
		return s;
	}
	
	// Returns w and h
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	public boolean getVisable() {
		return isVisable;
	}
	
	// Modifiers - Change data in Actor
	public void setColor(int col) {
		c = col;
		paint.setColor(c);
	}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
	}
	
	public void setDX(int speed) {
		dx = speed;
	}
	
	public void setDY(int speed) {
		dy = speed;
	}
	
	public void changeDX(float a) {
		dx += a;
	}
	
	public void changeDY(float a) {
		dy += a;
	}
	
	public void move() {
		p.x += dx;
		p.y += dy;
	}
	
	public void setWidth(int width) {
		w = width;
	}
	
	public void setHeight(int height) {
		h = height;
	}
	
	public void setVisable(boolean v) {
		isVisable = v;
	}
	
	public void bounce(Canvas c) {
		if (p.x + s > c.getWidth() || p.x < 0) {
			dx = dx * -1;
		}
		if (p.y + s > c.getHeight() || p.y < 0) {
			dy = dy * -1;
		}
	}
	
	public void bounceActor(Actor a) {
		
	}
	
	// Last functions for Actor
	public void drawCircle(Canvas c) {
		c.drawCircle(p.x, p.y, s, paint);
	}
	
	public void drawSquare(Canvas c) {
		c.drawRect(p.x, p.y, p.x+s, p.y+s, paint);
	}
	
	public void drawRect(Canvas c) {
		if (isVisable) {
			c.drawRect(p.x, p.y, p.x+w, p.y+h, paint);
		}
	}
	
	// Bounce up
	public void bounceUp() {
		dy = dy * -1;
	}
	
	//Function to return true of false if touching another Actor
	public boolean isTouching(Actor a) {
		boolean result = false;
		
		if ((p.x + w > a.getX() && p.x < a.getX() + a.getWidth()) &&
			(p.y + h > a.getY() && p.y+h < a.getY() + a.getHeight())) {
			result = true;
		}
		
		return result;
	}
	
	//Bounce Off Function
	public void bounceOff() {
		dx = dx * -1;
		dy = dy * -1;
	}
	
	public void setCostume(int cost) {
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
		// Set width and height on graphic
		w = graphic.getBitmap().getWidth();
		h = graphic.getBitmap().getHeight();
	}
	
	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		c.drawBitmap(getBitmap(), p.x, p.y, paint);
	}
	

}








