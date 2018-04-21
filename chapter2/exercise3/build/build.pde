// Ch. 2 Forces
// Example 2

Mover[] movers = new Mover[20];

void setup() {
    size(640, 360);
    background(255);

    for (int i = 0; i < movers.length; i++) {
        movers[i] = new Mover(random(width), random(height), random(3, 10));
    }
}

void draw() {
    background(255, 10);

    PVector forceFloat = new PVector(0, -0.01);

    for (int i = 0; i < movers.length; i++) {
        // movers[i].applyForce(forceFloat);
        movers[i].invisibleRetainingForce();
        movers[i].update();
        // movers[i].checkEdges();
        movers[i].display();
    }

}

void mousePressed() {
    PVector wind = new PVector(map(noise(millis()), 0, 1, -0.5, 0.5), 0);
    for (int i = 0; i < movers.length; i++) {
        movers[i].applyForce(wind);
    }
}
