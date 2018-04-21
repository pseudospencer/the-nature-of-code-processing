class Mover {

    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    float mass;

    Mover(float x, float y, float m) {
        // If you pass values, this constructor is called
        mass = m;
        dimension = new PVector(m * 16, m * 16);
        location = new PVector(x, y);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
    }

    Mover() {
        // This one's for the lazy ppl out there
        float x = random(width);
        float y = random(height);
        float m = 10;
        mass = m;
        dimension = new PVector(m * 16, m * 16);
        location = new PVector(x, y);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
    }

    void applyForce(PVector force) {
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }

    void update() {
        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0);  // Clear acceleration
    }

    void display() {
        stroke(0);
        fill(175);
        ellipse(location.x, location.y, dimension.x, dimension.y);
    }

    void checkEdges() {
        // wraps around sides
        if (location.x > width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = width;
        }
        // bounces off top and bottom
        if (location.y < 0) {
            velocity.y *= -1;
            location.y = 0;
        } else if (location.y > height) {
            velocity.y *= -1;
            location.y = height;
        }
    }

    void invisibleRetainingForce() {
        // an omnidirectional force that keeps the movers away from the edges
        PVector center = new PVector(width/2, height/2);
        PVector dir = PVector.sub(location, center);
        // Signs for force direction/ distance are flipped, to bring towards center
        PVector invisibleforce = new PVector(
            map(dir.x, -width/2, width/2, 0.01, -0.01), map(dir.y, -height/2, height/2, 0.01, -0.01)
            );

        applyForce(invisibleforce);
    }

}
