// Ch 1. Vectors
// Example 3

void setup() {
    size(640, 360);
    background(255);

}

void draw() {
    background(255);

    PVector mouse = new PVector(mouseX, mouseY);
    PVector center = new PVector(width/2, height/2);

    mouse.sub(center);

    translate(center.x,center.y);
    line(0, 0, mouse.x, mouse.y);
}
