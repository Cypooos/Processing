
float details = 0.001;
int number = 15;
float frame = 0;
float radius_max = 0;
float radius_min = 1200;
float width_an = 30;
float height_an = 0;

void setup () {
  size(1200, 800);
  stroke(0);
}

void draw () {
  background(255);
    float angle = 0;
    
    float old_x = radius_min*cos(angle);
    float old_y = 400+ radius_min*sin(angle);
    float old_off = 0.;
     
    for (float v = 0; v <= 1; v+= details ) {
      strokeWeight(40-v*40);
      
      float offset = (noise(10*v+angle+frame)-0.5)*800*(1.2-v*v);
      float xpos = (radius_min-v*(radius_min-radius_max))*cos(angle);
      float ypos = 400+ (radius_min-v*(radius_min-radius_max))*sin(angle);
      //circle(xpos + offset*cos(angle), ypos + offset*sin(angle), 20);
      
      line(xpos + offset*sin(angle), ypos - offset*cos(angle), old_x+ old_off*sin(angle), old_y- old_off*cos(angle));
      old_x = xpos;
      old_y = ypos;
      old_off = offset;
      
    }
    
  frame +=0.01;
}
