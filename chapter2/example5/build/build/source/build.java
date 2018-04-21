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
// Example 5
Liquid liquid;
Mover[] movers = new Mover[20];

public void setup() {
    
    background(255);

    liquid = new Liquid(0, height/2, width, height/2, 0.2f);

    for (int i = 0; i < movers.length; i++) {
        movers[i] = new Mover(random(width), random(height), random(3,6));
    }
}

public void draw() {
    background(255, 10);
    liquid.display();

    for (int i = 0; i < movers.length; i++) {

        if (movers[i].isInside(liquid)) {
            movers[i].drag(liquid);
        }

        float m = movers[i].mass;
        PVector gravity = new PVector(0, 0.1f * m);
        movers[i].applyForce(gravity);

        movers[i].update();
        movers[i].checkEdges();
        movers[i].display();
    }

}

public void mousePressed() {
    PVector wind = new PVector(map(noise(millis()), 0, 1, -0.5f, 0.5f), 0);
    for (int i = 0; i < movers.length; i++) {
        movers[i].applyForce(wind);
    }
}
class Liquid {
    // A liquid-like substance that drags on objects
    float x, y, w, h;
    float c; // coefficient

    Liquid(float x_, float y_, float w_, float h_, float c_) {
        x = x_;
        y = y_;
        w = w_;
        h = h_;
        c = c_;
    }

    public void display() {
        noStroke();
        fill(0, 0, 175); // make it blue
        rect(x, y, w, h);
    }


}
class Mover {

    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    float mass;

    Mover(float x, float y, float m) {
        // If you pass values, this constructor is called
        mass = m;
        dimension = new PVector(m * 16, m * 16);
        location = new PVector(x, y);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
    }

    Mover() {
        // This one's for the lazy ppl out there
        float x = random(width);
        float y = random(height);
        float m = 10;
        mass = m;
        dimension = new PVector(m * 16, m * 16);
        location = new PVector(x, y);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
    }

    public void applyForce(PVector force) {
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);  // Clear acceleration
    }

    public void display() {
        stroke(0);
        fill(175);
        ellipse(location.x, location.y, dimension.x, dimension.y);
    }

    public void checkEdges() {
        // wraps around sides
        if (location.x > width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = width;
        }
        // bounces off top and bottom
        if (location.y < 0) {
            // velocity.y *= -1;
            location.y = 0;
        } else if (location.y > height) {
            velocity.y *= -0.9f;
            location.y = height;
        }
    }

    public boolean isInside(Liquid l) {
        if (location.x > l.x && location.x < l.w && location.y > l.y && location.y < l.h) {
            return true;
        } else {
            return false;
        }
    }

    public void drag(Liquid l) {
        float speed = velocity.mag();
        float dragMagnitude = l.c * speed * speed;

        PVector drag = velocity.get();
        drag.mult(-1);
        drag.normalize();

        drag.mult(dragMagnitude);
        applyForce(drag);
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
