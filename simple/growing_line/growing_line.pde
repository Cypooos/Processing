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

  float orbitRadius= 100;
  float ypos= 0;
  float xpos= cos(radians(frame/10))*orbitRadius;
  float zpos= sin(radians(frame/10))*orbitRadius;
  camera(xpos, ypos, zpos, 0, 0, 0, 0, -1, 0);

    
  float x = 0;
  float y = 0;
  float z = 0;
  for (int ele = 0; ele <= min(10000,frame*2); ele +=1) {
      
    float dx = 2*( noise(float(ele)/100,75+frame/1000) - (x/orbitRadius) -0.5 );
    float dy = 2*( noise(float(ele)/100,50+frame/1000) - (y/orbitRadius) -0.5 );
    float dz = 2*( noise(float(ele)/100,100+frame/1000)- (z/orbitRadius) -0.5 );
    
    line(x, y, z, x+dx, y+dy, z+dz);
    x += dx;
    y += dy;
    z += dz;
    
  }
  frame +=1;
}
