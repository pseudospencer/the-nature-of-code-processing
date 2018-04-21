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

public class build extends PApplet {

// Ch 1. Vectors
// Example 1

float x = 100;
float y = 100;
float xSpeed = 0;
float ySpeed = 3.3f;

public void setup() {
    
    background(255);
}

public void draw() {
    background(255);
    x = x + xSpeed;
    y = y + ySpeed;

    if ( x > width || x < 0) {
        xSpeed = -xSpeed;
    }
    if (y > height || y < 0) {
        ySpeed = -ySpeed;
    }

    stroke(0);
    fill(175);
    ellipse(x,y,16,16);
}
  public void settings() {  size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
