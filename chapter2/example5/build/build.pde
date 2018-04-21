// Ch. 2 Forces
// Example 5
Liquid liquid;
Mover[] movers = new Mover[20];

void setup() {
    size(640, 360);
    background(255);

    liquid = new Liquid(0, height/2, width, height/2, 0.2);

    for (int i = 0; i < movers.length; i++) {
        movers[i] = new Mover(random(width), random(height), random(3,6));
    }
}

void draw() {
    background(255, 10);
    liquid.display();

    for (int i = 0; i < movers.length; i++) {

        if (movers[i].isInside(liquid)) {
            movers[i].drag(liquid);
        }

        float m = movers[i].mass;
        PVector gravity = new PVector(0, 0.1 * m);
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
