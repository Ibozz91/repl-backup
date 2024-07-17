from turtle import *
hideturtle()
speed(0)
def sierpenski(depth, maxx, maxy, minx, miny):
  if(depth>1 and abs(maxy-miny)>3 and abs(maxx-minx)>3):
    sierpenski(depth-1, (minx+maxx)/2, (miny+maxy)/2, minx, miny)
    sierpenski(depth-1, maxx, (miny+maxy)/2, (minx+maxx)/2, miny)
    sierpenski(depth-1, (3*minx+maxx)/4, maxy, (3*maxx+minx)/4, (miny+maxy)/2)
  else:
    up()
    goto(minx, miny)
    down()
    goto(maxx, miny)
    goto((maxx+minx)/2, maxy)
    goto(minx, miny)
sierpenski(int(input("What do you want the depth to be?")), screensize()[0]/2, screensize()[1]/2, -screensize()[0]/2, -screensize()[1]/2)