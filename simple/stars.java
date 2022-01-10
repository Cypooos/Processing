// Drawing lines in 3D requires P3D
// as a parameter to size()


int radius = 100;

float frame = 0.0;



void setup () {
  size(800, 800, P3D);
  stroke(255);
  camera(100, 0, 0, 0, 0, 0, 0, -1, 0);

}

void draw () {
  background(0);

   float orbitRadius= mouseX/2+50;
  float ypos= mouseY/3;
  float xpos= cos(radians(frame/3))*orbitRadius;
  float zpos= sin(radians(frame/3))*orbitRadius;
  //camera(xpos, ypos, zpos, 0, 0, 0, 0, -1, 0);

  for (int tree = 0; tree <= 10; tree++) {
    
    float x = 0;
    float y = 0;
    float z = 0.0;
    for (int ele = 0; ele <= 100; ele +=1) {
      
      float dx = 1.5*( noise(float(ele)/1000,-50+tree+frame/1000) - 0.5 );
      float dy = 1.5*( noise(float(ele)/1000,2+tree+frame/1000) - 0.5 );
      float dz = 1.5*( noise(float(ele)/1000,100+tree+frame/1000) - 0.5 );
    
      line(x, y, z, x+dx, y+dy, z+dz);
      x += dx;
      y += dy;
      z += dz;
    
    }
  }
  frame +=1;
}
