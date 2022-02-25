
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
    
     
    for (float v = 0; v <= 1; v+= details ) {
      strokeWeight(50-v*50);
      
      float offset = sin(frame)*50;
      float xpos = 0;
      float ypos = 0;
      circle(xpos + offset*cos(angle), ypos + offset*sin(angle), 20);
      
      //line(xpos, ypos, xpos+dx+dx_to0, ypos+dy+dy_to0);
      
    }
    
  }
  frame +=0.01;
}
