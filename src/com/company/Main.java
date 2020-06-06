import processing.video.*;
// 2 variables
float x;
        float y;

//Variable para aferrarse al objeto Capturar.

        Capture video;

        void setup() {
        size(320, 240);
        background(255);
        // Comienza x e y en el centro
        x = width/2;
        y = height/2;
        // empieza el proceso de captura
        video = new Capture(this, width, height);
        video.start();
        }

        void captureEvent(Capture video) {
        // lee la imagen de la cámara
        video.read();
        }

        void draw() {
        video.loadPixels();
        float newx = constrain(x + random(-20, 20), 0, width);
        float newy = constrain(y + random(-20, 20), 0, height-1);

        // Encuentra el punto medio de la línea
        int midx = int((newx + x) / 2);
        int midy = int((newy + y) / 2);
        //Elige el color del video, invirtiendo x
        color c = video.pixels[(width-1-midx) + midy*video.width];

        // Dibuja una línea desde (x, y) hasta (newx, newy)
        stroke(c);
        strokeWeight(4);
        line(x, y, newx, newy);

        // guardar (newx,newy) en (x,y)
        x = newx;
        y = newy;
        }