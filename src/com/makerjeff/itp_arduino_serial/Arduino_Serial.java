package com.makerjeff.itp_arduino_serial;
import processing.core.*;
import processing.serial.*;

public class Arduino_Serial extends PApplet{
	
	float diameter = 100.0f;
	int[] colors = {
			color(50,50,50), 
			color(255,0,0), 
			color(0,255,0), 
			color(0,0,255)
			};
	int xPos = 0;

	public static void main(String[] args) {
		PApplet.main("com.makerjeff.itp_arduino_serial.Arduino_Serial");
	}
	
	public void settings(){
		size(400, 400);
	} 
	
	public void setup(){
		smooth();
		frameRate(30.0f);
		
		for(int i = 0; i < colors.length; i++) {
			print(colors[i] + "\r\n");
		}
	} 
	
	public void draw(){
		
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
