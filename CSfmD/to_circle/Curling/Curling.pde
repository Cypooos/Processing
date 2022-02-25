
float details = 0.1;
int number = 15;
float frame = 0;
float radius_max = 100;
float width_an = 30;
float height_an = 0;

void setup () {
  size(800, 800);
  stroke(0);
}

void draw () {
  background(255);
  
  for (int ele = 0; ele < number; ele +=1) {
    float angle = 360*ele/number;
    
    float xpos= cos(radians(angle))*800 + 400;
    float ypos= sin(radians(angle))*800 + 400;
    float dx_to0 = -cos(radians(angle))*(800-radius_max)*details;
    float dy_to0 = -sin(radians(angle))*(800-radius_max)*details;
     
    for (float v = 0; v <= 1; v+= details ) {
      strokeWeight(50-v*50); 
      float dx = cos(v*50)*((width_an*noise(v))*sin(radians(angle)) );
      float dy = sin(v*50)*((width_an*noise(v))*cos(radians(angle)));
      line(xpos, ypos, xpos+dx+dx_to0, ypos+dy+dy_to0);
      
      xpos += dx+dx_to0 ;
      ypos += dy+dy_to0;
      
    }
    
  }
  frame +=0.05;
  details /= 1.005;
}
