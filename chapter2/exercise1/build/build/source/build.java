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

// Ch. 2 Forces
// Exercise 1

// Baloon[] baloons = new Baloon[1];

Baloon b;

public void setup() {
    
    background(255);
    b = new Baloon();
}

public void draw() {
    background(255, 10);

    PVector forceFloat = new PVector(0, -0.01f);
    b.applyForce(forceFloat);

    b.update();
    b.checkEdges();
    b.display();
}

public void mousePressed() {
    PVector wind = new PVector(map(noise(millis()), 0, 1, -0.5f, 0.5f), 0);
    b.applyForce(wind);
}
class Baloon {

    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    float mass;

    Baloon() {
        dimension = new PVector(30, 30);
        location = new PVector(random(width), random(height));
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
        mass = 1;
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);
        // Clear acceleration
        acceleration.mult(0);
    }

    public void display() {
        stroke(0);
        fill(175);
        ellipse(location.x, location.y, dimension.x, dimension.y);
    }

    public void checkEdges() {
        if (location.x > width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = width;
        }
        // Baloon bounces off top, doesn't wrap around edge.
        if (location.y < 0) {
            velocity.y *= -1;
            location.y = 0;
        }
    }

    public void applyForce(PVector force) {
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }
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
