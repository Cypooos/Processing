float frame = 0;
int nb_X = 10;
int nb_Y = 10;
int pad_X;
int pad_Y;
int grid = 70;
int layers = 6; // 0 included

void setup() {
  size(800,800);
  frame = 0;
  pad_X = (width - grid*nb_X )/2;
  pad_Y = (height - grid*nb_Y )/2;
  //pad_X -= grid/2;
  //pad_Y -= grid/2;
  print(pad_X,pad_Y);
  
  //lights();
  noStroke();

  background(255, 122, 125);
  fill(255,255,255);
  rect(pad_X, pad_Y, grid*nb_X, grid*nb_Y);
  
  
  for (int z = 0; z < layers; z++) {
    if (z == 0) {
      fill(255,245,245);
    } else if (z == 1) {
      fill(240,230,230);
    }else if (z == 2) {
      fill(230,200,200);
    }else if (z == 3) {
      fill(200,150,150);
    }else if (z == 4) {
      fill(100,50,50);
    }else if (z == 5) {
      fill(00,0,00);
    }
    for (int x = 0; x < nb_X; x ++) {
      for (int y = 0; y < nb_Y; y++) {
        // coordonate of the hole from the top left corners
        int x1 = int(random(5,grid/(2+z)));
        int y1 = int(random(5,grid/(2+z)));
        int x2 = int(random(z*grid/(2+z),grid-5));
        int y2 = int(random(z*grid/(2+z),grid-5));
        
        // position of the top left corner of the grid square
        int px = pad_X + x*grid;
        int py = pad_Y + y*grid;
        
        // 4 rect with a whole representing the cardboard "mask"
        rect(px, py, x1, grid);
        rect(px+x2, py, grid-x2, grid);
        rect(px, py,  grid, y1);
        rect(px, py+y2, grid, grid-y2);
      };
    };
  };
};

void draw() {
  frame += 0.001;

}
