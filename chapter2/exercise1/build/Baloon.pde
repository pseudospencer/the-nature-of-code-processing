class Baloon {

    PVector dimension;
    PVector location;
    PVector velocity;
    PVector acceleration;
    float mass;

    Baloon() {
        dimension = new PVector(30, 30);
        location = new PVector(random(width), random(height));
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
        mass = 1;
    }

    void update() {
        velocity.add(acceleration);
        location.add(velocity);
        // Clear acceleration
        acceleration.mult(0);
    }

    void display() {
        stroke(0);
        fill(175);
        ellipse(location.x, location.y, dimension.x, dimension.y);
    }

    void checkEdges() {
        if (location.x > width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = width;
        }
        // Baloon bounces off top, doesn't wrap around edge.
        if (location.y < 0) {
            velocity.y *= -1;
            location.y = 0;
        }
    }

    void applyForce(PVector force) {
        PVector f = PVector.div(force, mass);
        acceleration.add(f);
    }
}
