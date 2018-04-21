// Ch 1. Vectors
// Example 7

Mover m;

void setup() {
    size(640, 360);
    background(255);
    m = new Mover();
}

void draw() {
    background(255);

    m.update();
    m.checkEdges();
    m.display();
}

class Mover {
    PVector location;
    PVector velocity;
    PVector dimension;

    void update() {
        location.add(velocity);
    }

    void display() {
        stroke(0);
        fill(175);
        ellipse(location.x, location.y, dimension.x, dimension.y);
    }

    void checkEdges() {
        if (location.x > width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = width;
        }

        if (location.y > height) {
            location.y = 0;
        } else if (location.y < 0) {
            location.y = height;
        }
    }

    Mover() {
        location = new PVector(random(width), random(height));
        velocity = new PVector(random(-2, 2), random(-2, 2));
        dimension = new PVector(16, 16);
    }
}
