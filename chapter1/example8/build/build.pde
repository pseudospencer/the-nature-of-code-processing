// Ch 1. Vectors
// Example 8

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
    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    float topSpeed;

    void update() {
        velocity.add(acceleration);
        velocity.limit(topSpeed);
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
        dimension = new PVector(16, 16);
        location = new PVector(random(width), random(height));
        velocity = new PVector(0, 0);
        acceleration = new PVector(-0.001, 0.01);
        topSpeed = 10;
    }
}
