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

// Intro Example 1
Walker w;

public void setup() {
    
    w = new Walker();
    background(255);
}

public void draw() {
    w.step();
    w.display();
}

class Walker {
    int x;
    int y;

    Walker() {
        x = width/2;
        y = height/2;
    }

    public void display() {
        stroke(0);
        point(x,y);
    }

    public void step() {
        float r = random(1);
        if (r < 0.4f) {
            x++;
        } else if (r < 0.6f) {
            x--;
        } else if (r < 0.8f) {
            y++;
        } else {
            y--;
        }
    }


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
