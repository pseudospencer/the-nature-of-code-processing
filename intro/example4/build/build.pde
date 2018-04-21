// Example 4

void setup() {
    size(640, 340);
    background(255);
}

void draw() {
    float num = randomGaussian();
    float sd = 60;
    float mean = width/2;

    float x = sd * num + mean;

    noStroke();
    fill(0, 10);
    ellipse(x, height/2, 16, 16);
}
