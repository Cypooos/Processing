float frame = 0;
int nb_X = 10;
int nb_Y = 14;
int pad_X;
int pad_Y;
int grid = 50;
int taille = 20;
int randomness = 5;


void setup () {
  frame = 0;
  size(840, 840);
  pad_X = (width - grid*nb_X )/2;
  pad_Y = (height - grid*nb_Y )/2;
  background(128);
};

void draw() {
  background(128);
  for (int x = 0; x <= nb_X; x ++) {
    for (int y = 0; y <= nb_Y; y++) {
      if (noise(float(x)/randomness,float(y)/randomness, 0+frame )<=0.5) {
        blendMode(DARKEST);
      } else {
        blendMode(LIGHTEST);
      };
      
      if (noise(float(x)/randomness,float(y)/randomness, 1+ frame)<=0.5) {
        fill(0);
        stroke(255);
      } else {
        fill(255);
        stroke(0);
      };
      
      int tx = pad_X + x*grid;
      int ty = pad_Y + y*grid;
      
      if (noise(float(x)/randomness,float(y)/randomness, 2+frame )<=0.5) {
        square(tx-taille/2,ty-taille/2,taille/2);
        square(tx,ty,taille/2);
        square(tx-taille/4,ty-taille/4,taille/2);
        
      } else {
        square(tx-taille/2,ty-taille/2,taille);
        square(tx-taille/4,ty-taille/4,taille/2);
      };
    };
  };
  frame += 0.001;
};
