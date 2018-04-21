class Liquid {
    // A liquid-like substance that drags on objects
    float x, y, w, h;
    float c; // coefficient

    Liquid(float x_, float y_, float w_, float h_, float c_) {
        x = x_;
        y = y_;
        w = w_;
        h = h_;
        c = c_;
    }

    void display() {
        noStroke();
        fill(0, 0, 175); // make it blue
        rect(x, y, w, h);
    }


}
