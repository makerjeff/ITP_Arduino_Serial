package com.makerjeff.itp_arduino_serial;
import processing.core.*;
import processing.serial.*;
import processing.video.*;

public class WebCam extends PApplet{
	
	Capture cam;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("com.makerjeff.itp_arduino_serial.WebCam");
	}
	
	//== SETTINGS ==
	public void settings(){
		//initialize settings; New in Processing 3.0
		size(1280, 720);
	} 
	
	//== SETUP ==
	public void setup(){
	
		smooth();	//setup smoothing
		print("initialized \r\n");	//initialize message
		
		//grab a list of available cameras and resolutions
		String[] cameras = Capture.list();
		
		// if no cameras are found...
		if(cameras.length == 0){
			print("no cameras available");
			exit();
		}
		
		// otherwise...
		else {
			// print available cameras to console
			print("Available Cameras: \r\n");
			for(int i = 0; i < cameras.length; i++) {
				print(i + ": " + cameras[i] + "\r\n");
			}
			
			//create new Capture object with a parent of 'this', which is PApplet.
			cam = new Capture(this, cameras[0]);
			cam.start();	//start camera
		}
	}
	
	//== DRAW ==
	public void draw(){
		//if cameras are available...
		if(cam.available() == true) {
			//read from camera stream
			cam.read();
			//draw image with camera stream 
			image(cam,0,0);
			//set(0,0,cam); is faster, if no effects
		}
	}

}
