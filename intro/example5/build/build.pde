// Intro Example 3
Walker w;

void setup() {
    size(640, 340);
    w = new Walker();
    background(255);
}

void draw() {
    w.step();
    w.display();
}

class Walker {
    float x, y;
    float tx, ty;

    Walker() {
        // x = width/2;
        // y = height/2;
        tx = 0;
        ty = 10000;
    }

    void display() {
        stroke(0);
        point(x,y);
    }

    void step() {
        x = map(noise(tx), 0, 1, 0, width);
        y = map(noise(ty), 0, 1, 0, height);

        tx += 0.01;
        ty += 0.01;
    }


}
