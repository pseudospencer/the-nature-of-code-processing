// Intro Example 1
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
    int x;
    int y;

    Walker() {
        x = width/2;
        y = height/2;
    }

    void display() {
        stroke(0);
        point(x,y);
    }

    void step() {
        int choice = int(random(4));
        if (choice == 0) {
            x++;
        } else if (choice == 1) {
            x--;
        } else if (choice == 2) {
            y++;
        } else if (choice == 3) {
            y--;
        }
    }


}