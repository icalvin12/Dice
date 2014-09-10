import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die one;
int total;
public void setup()
{
	size(300,310);
	rectMode(CENTER);
	noLoop();
}
public void draw()
{
	background(255);
	for(int y = -25;y<=300;y+=50)
	{
		for(int x = -25;x<=300;x+=50)
		{
			one = new Die(x,y);
			one.show();
			one.roll();
		}
	}
	text("Total: " + total, 5, 310);
}
public void mousePressed()
{
	redraw();
	total = 0;
}
class Die 
{
	int myX,myY,myNum;
	Die(int x, int y) //constructor
	{
		myX = x;
		myY = y;
		myNum = (int)(Math.random() * 6)+1; 
	}
	public void roll()
	{
		total = total + myNum;
		if(myNum == 1)
		{
			ellipse(myX,myY,10,10);
		}
		if(myNum == 2)
		{
			ellipse(myX-15,myY-15,10,10);
			ellipse(myX+15,myY+15,10,10);
		}
		if(myNum == 3)
		{
			ellipse(myX,myY,10,10);
			ellipse(myX-15,myY-15,10,10);
			ellipse(myX+15,myY+15,10,10);
		}
		if(myNum == 4)
		{
			ellipse(myX+10,myY+10,10,10);
			ellipse(myX+10,myY-10,10,10);
			ellipse(myX-10,myY+10,10,10);
			ellipse(myX-10,myY-10,10,10);
		}
		if(myNum == 5)
		{
			ellipse(myX+10,myY+10,10,10);
			ellipse(myX+10,myY-10,10,10);
			ellipse(myX-10,myY+10,10,10);
			ellipse(myX-10,myY-10,10,10);
			ellipse(myX,myY,10,10);
		}
		if(myNum == 6)
		{
			ellipse(myX-15,myY-15,10,10);
			ellipse(myX-15,myY,10,10);
			ellipse(myX-15,myY+15,10,10);
			ellipse(myX+15,myY+15,10,10);
			ellipse(myX+15,myY,10,10);
			ellipse(myX+15,myY-15,10,10);
		}
	}
	public void show()
	{
		fill(255,255,255);
		rect(myX,myY,50,50);
		fill(0,0,0);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
