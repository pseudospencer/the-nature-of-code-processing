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

// Example 4

public void setup() {
    
    background(255);
}

public void draw() {
    float num = randomGaussian();
    float sd = 60;
    float mean = width/2;

    float x = sd * num + mean;

    noStroke();
    fill(0, 10);
    ellipse(x, height/2, 16, 16);
}
  public void settings() {  size(640, 340); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
