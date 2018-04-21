// Ch. 2 Forces
// Example 4

Mover[] movers = new Mover[20];

void setup() {
    size(640, 360);
    background(255);

    for (int i = 0; i < movers.length; i++) {
        movers[i] = new Mover(random(width), random(height), random(3,6));
    }
}

void draw() {
    background(255, 10);

    PVector gravity = new PVector(0, 0.1);

    for (int i = 0; i < movers.length; i++) {

        float c = 0.01; // coefficient of friction
        PVector friction = movers[i].velocity.get(); // get current velocity
        friction.mult(-1); // friction is opposite direction from velocity
        friction.normalize(); // convert to unit vector
        friction.mult(c);

        movers[i].applyForce(friction);
        movers[i].applyForce(gravity);

        movers[i].update();
        movers[i].checkEdges();
        movers[i].display();
    }

}

void mousePressed() {
    PVector wind = new PVector(map(noise(millis()), 0, 1, -0.5, 0.5), 0);
    for (int i = 0; i < movers.length; i++) {
        movers[i].applyForce(wind);
    }
}
