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
// Example 2

// float x = 100;
// float y = 100;
// float xSpeed = 0;
// float ySpeed = 3.3;
PVector location;
PVector velocity;
PVector dimension;


public void setup() {
    
    background(255);
    location = new PVector(100, 100);
    velocity = new PVector(2.5f, 5);
    dimension = new PVector(16, 16);
}

public void draw() {
    background(255);
    // x = x + xSpeed;
    // y = y + ySpeed;
    location.add(velocity);

    // if ( x > width || x < 0) {
    //     xSpeed = -xSpeed;
    // }
    // if (y > height || y < 0) {
    //     ySpeed = -ySpeed;
    // }
    if (location.x > width || location.x < 0) {
        velocity.x = -velocity.x;
    }
    if (location.y > height || location.y < 0) {
        velocity.y = -velocity.y;
    }

    stroke(0);
    fill(175);
    ellipse(location.x,location.y,dimension.x, dimension.y);
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
