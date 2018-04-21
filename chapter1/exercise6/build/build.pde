// Ch 1. Vectors
// Example 9

Mover m;

void setup() {
    size(640, 360);
    background(255);
    m = new Mover();
}

void draw() {
    background(255, 10);

    m.update();
    m.checkEdges();
    m.display();
}

class Mover {
    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    PVector time;
    PVector timeStepper;
    float topSpeed;

    void update() {
        acceleration.x = map(noise(time.x), 0, 1, -0.002, 0.002);
        acceleration.y = map(noise(time.y), 0, 1, -0.002, 0.002);
        time.add(timeStepper);

        velocity.add(acceleration);
        velocity.limit(topSpeed);
        location.add(velocity);

        // println("acceleration: ", acceleration, " velocity: ", velocity, " location: ", location);
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
        acceleration = new PVector(0, 0);
        time = new PVector(random(10000), random(10000));
        topSpeed = 10;
        timeStepper = new PVector(0.1, 0.1);
    }
}
