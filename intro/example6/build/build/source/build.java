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

// Intro Example 6

float xOff = 0.0f;

public void setup() {
    
    background(255);
}

public void draw() {
    loadPixels();
    for (int x = 0; x < width; x++) {
        float yOff = 0.0f;
        for (int y = 0; y < height; y++) {
                float bright = map(noise(xOff, yOff), 0, 1, 0, 255);
                pixels[x + y * width] = color(bright);
                yOff += 0.01f;
        }
        xOff += 0.01f;
    }
    updatePixels();
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
