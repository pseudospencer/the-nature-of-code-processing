// Intro Example 6

float xOff = 0.0;

void setup() {
    size(640, 340);
    background(255);
}

void draw() {
    loadPixels();
    for (int x = 0; x < width; x++) {
        float yOff = 0.0;
        for (int y = 0; y < height; y++) {
                float bright = map(noise(xOff, yOff), 0, 1, 0, 255);
                pixels[x + y * width] = color(bright);
                yOff += 0.01;
        }
        xOff += 0.01;
    }
    updatePixels();
}
