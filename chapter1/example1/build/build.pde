// Ch 1. Vectors
// Example 1

float x = 100;
float y = 100;
float xSpeed = 0;
float ySpeed = 3.3;

void setup() {
    size(640, 360);
    background(255);
}

void draw() {
    background(255);
    x = x + xSpeed;
    y = y + ySpeed;

    if ( x > width || x < 0) {
        xSpeed = -xSpeed;
    }
    if (y > height || y < 0) {
        ySpeed = -ySpeed;
    }

    stroke(0);
    fill(175);
    ellipse(x,y,16,16);
}
