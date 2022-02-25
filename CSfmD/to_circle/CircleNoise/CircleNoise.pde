
float details = 0.01;
int number = 15;
float frame = 0;
float radius_max = 100;
float radius_min = 600;
float width_an = 30;
float height_an = 0;

void setup () {
  size(800, 800);
  stroke(0);
}

void draw () {
  background(255);
  
  for (int ele = 0; ele < number; ele +=1) {
    float angle = radians(360*ele/number);
    
    float old_x = 400+ radius_min*cos(angle);
    float old_y = 400+ radius_min*sin(angle);
    float old_off = 0.;
     
    for (float v = 0; v <= 1; v+= details ) {
      strokeWeight(20-v*v*v*20);
      
      float offset = sin(radians(5*v*360+frame)*noise(v*2+ele+frame))*20;
      float xpos = 400+ (radius_min-v*(radius_min-radius_max))*cos(angle);
      float ypos = 400+ (radius_min-v*(radius_min-radius_max))*sin(angle);
      //circle(xpos + offset*cos(angle), ypos + offset*sin(angle), 20);
      
      line(xpos + offset*sin(angle), ypos - offset*cos(angle), old_x+ old_off*sin(angle), old_y- old_off*cos(angle));
      old_x = xpos;
      old_y = ypos;
      old_off = offset;
      
    }
    
  }
  frame +=0.01;
}
