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
        int choice = PApplet.parseInt(random(4));
        if (choice == 0) {
            x++;
        } else if (choice == 1) {
            x--;
        } else if (choice == 2) {
            y++;
        } else if (choice == 3) {
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
