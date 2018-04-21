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

// Intro Example 3
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
    float x, y;
    float tx, ty;

    Walker() {
        // x = width/2;
        // y = height/2;
        tx = 0;
        ty = 10000;
    }

    public void display() {
        stroke(0);
        point(x,y);
    }

    public void step() {
        x = map(noise(tx), 0, 1, 0, width);
        y = map(noise(ty), 0, 1, 0, height);

        tx += 0.01f;
        ty += 0.01f;
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
