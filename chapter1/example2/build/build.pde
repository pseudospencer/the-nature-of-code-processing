// Ch 1. Vectors
// Example 2

// float x = 100;
// float y = 100;
// float xSpeed = 0;
// float ySpeed = 3.3;
PVector location;
PVector velocity;
PVector dimension;


void setup() {
    size(640, 360);
    background(255);
    location = new PVector(100, 100);
    velocity = new PVector(2.5, 5);
    dimension = new PVector(16, 16);
}

void draw() {
    background(255);
    // x = x + xSpeed;
    // y = y + ySpeed;
    location.add(velocity);

    // if ( x > width || x < 0) {
    //     xSpeed = -xSpeed;
    // }
    // if (y > height || y < 0) {
    //     ySpeed = -ySpeed;
    // }
    if (location.x > width || location.x < 0) {
        velocity.x = -velocity.x;
    }
    if (location.y > height || location.y < 0) {
        velocity.y = -velocity.y;
    }

    stroke(0);
    fill(175);
    ellipse(location.x, location.y, dimension.x, dimension.y);
}
