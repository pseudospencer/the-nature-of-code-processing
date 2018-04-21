// Ch. 2 Forces
// Exercise 1

// Baloon[] baloons = new Baloon[1];

Baloon b;

void setup() {
    size(640, 360);
    background(255);
    b = new Baloon();
}

void draw() {
    background(255, 10);

    PVector forceFloat = new PVector(0, -0.01);
    b.applyForce(forceFloat);

    b.update();
    b.checkEdges();
    b.display();
}

void mousePressed() {
    PVector wind = new PVector(map(noise(millis()), 0, 1, -0.5, 0.5), 0);
    b.applyForce(wind);
}
