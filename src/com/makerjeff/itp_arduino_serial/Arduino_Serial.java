package com.makerjeff.itp_arduino_serial;
import processing.core.*;
import processing.serial.*;

public class Arduino_Serial extends PApplet{
	
	float diameter = 100.0f;	//circle diameter
	int[] colors = {
			color(240,240,240),	//off white
			color(50,50,50), 	//gray
			color(255,0,0), 	//red
			color(0,255,0), 	//green
			color(0,0,255)		//blue
			};
	int xPos = 0;	//position 
	String myMessage = "This is my text message! I'm just putting in more text"
			+ " to fill in this block of text to experience wrapping.";

	public static void main(String[] args) {
		PApplet.main("com.makerjeff.itp_arduino_serial.Arduino_Serial");
	}
	
	public void settings(){
		size(400, 400);
	} 
	
	public void setup(){
		background(colors[0]);
		smooth();
		noStroke();
		frameRate(30.0f);
		
		//print array list
		printArray(Serial.list());
		
		//INITIALIZE SERIAL
		String portName = Serial.list()[5];
		Serial myPort = new Serial(this, portName, 9600);

		
	} 
	
	public void draw(){
		//AnimateCircle();
		textSize(20);
		fill(0,0,0);
		text(myMessage, 30, 45, 300,300);

	}
	
	//special Serial Event that's fired when there's serial data
	public void serialEvent (Serial myPort){
		//grab the byte
		int inByte = myPort.read();
		//print it out
		print(inByte + "\r\n");
	}
	
	//== CUSTOM FUNCTIONS ==
	//animate the circle
	public void AnimateCircle(){
		clear();
		background(colors[0]);
		fill(colors[1]);
		
		if(xPos >= width + diameter/2) {
			xPos = -1 * (int)diameter/2;
		}
		
		ellipse(xPos, height*0.5f, diameter, diameter);
		xPos += 2;
	} 
}


