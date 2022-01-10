int radius = 200;
float frame = 0.0;

void setup () {
  size(800, 800, P3D);
  stroke(255);
  camera(0, 0, radius, 0, 0, 0, 0, -1, 0);
}

void draw () {
  background(0);

  for (int creature = 0; creature <= 8; creature ++) {
    
    // Define center of the creature
    float c_x = (noise(creature,frame/1000,0)-0.5) *radius;
    float c_y = (noise(creature,frame/1000,1)-0.5 )*radius;
    float c_z = 0.0;
    
    for (int tree = 0; tree <= 4; tree++) {
      
      float x = c_x;
      float y = c_y;
      float z = c_z;
      for (int ele = 0; ele <= 100; ele +=1) {
        
        // move eatch point of leg using noise
        float dx = 1.5*( noise(float(ele)/100,tree+frame/1000,0+creature/3) - 0.5 );  
        float dy = 1.5*( noise(float(ele)/100,tree+frame/1000,1+creature/3) - 0.5 );
        float dz = 1.5*( noise(float(ele)/100,tree+frame/1000,2+creature/3) - 0.5 );
      
        // draw segment of the leg
        line(x, y, z, x+dx, y+dy, z+dz);
        // next point of the leg = ending of the noised point
        x += dx;
        y += dy;
        z += dz;
      
      }
    }
  }
  frame +=1;
}
