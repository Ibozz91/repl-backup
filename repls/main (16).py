from decimal import *
def equation(x1, y1, x2, y2):
  slope=(y2-y1)/(x2-x1)
  return [slope, y1-(x1*slope)]
def meetingpoint(equ1,equ2):
  x=(equ2[1]-equ1[1])/(equ1[0]-equ2[0])
  y=equ1[0]*x+equ1[1]
  return [x,y]
x1=Decimal(input("Enter x value for point 1\n"))
y1=Decimal(input("Enter y value for point 1\n"))
x2=Decimal(input("Enter x value for point 2\n"))
y2=Decimal(input("Enter y value for point 2\n"))
x3=Decimal(input("Enter x value for point 3\n"))
y3=Decimal(input("Enter y value for point 3\n"))
'''
Point 1: (x1, y1)
Point 2: (x2, y2)
Point 3: (x3, y3)
'''
print("Step 0: Did you make an actual triangle?\nTest 1: Are point 1 and point 2 unique?")
if x1==x2 and y1==y2:
  print("No! It is the coordinate pair ("+str(x1)+", "+str(y1)+")")
else:
  print("Test 2: Are point 2 and point 3 unique?")
  if x2==x3 and y2==y3:
    print("No! It is the coordinate pair ("+str(x2)+", "+str(y2)+")")
  else:
    print("Test 3: Do the coordinates make a triangle and not a straight line?")
    slope1=equation(x1,y1,x2,y2)
    slope2=equation(x2,y2,x3,y3)
    slope3=equation(x3,y3,x1,y1)
    if slope1 == slope2:
      print("No! The slope for the line is y="+str(slope1[0])+"x+"+str(slope1[1]))
    else:
      mx1=(x1+x2)/2
      my1=(y1+y2)/2
      mx2=(x2+x3)/2
      my2=(y2+y3)/2
      mx3=(x3+x1)/2
      my3=(y3+y1)/2
      pslope1=[-1/slope1[0],my1-(-mx1/slope1[0])]
      pslope2=[-1/slope2[0],my2-(-mx2/slope2[0])]
      pslope3=[-1/slope3[0],my3-(-mx3/slope3[0])]
      crcm=meetingpoint(pslope1, pslope2)
      print("PART 1: Circumcenter\nSlope of line 1: y="+str(slope1[0])+"x+"+str(slope1[1])+"\nPerpendicular Bisector: y="+str(pslope1[0])+"x+"+str(pslope1[1])+"\nSlope of line 2: y="+str(slope2[0])+"x+"+str(slope2[1])+"\nPerpendicular Bisector: y="+str(pslope2[0])+"x+"+str(pslope2[1])+"\nSlope of line 3: y="+str(slope3[0])+"x+"+str(slope3[1])+"\nPerpendicular Bisector: y="+str(pslope3[0])+"x+"+str(pslope3[1])+"\nThese meet at ("+str(crcm[0])+", "+str(crcm[1])+")")
      mslope1=equation(x1,y1,mx2,my2)
      mslope2=equation(x2,y2,mx3,my3)
      mslope3=equation(x3,y3,mx1,my1)
      md=meetingpoint(mslope1,mslope2)
      print("PART 2: Centroid\nMedian 1: y="+str(mslope1[0])+"x+"+str(mslope1[1])+"\nMedian 2: y="+str(mslope2[0])+"x+"+str(mslope2[1])+"\nMedian 3: y="+str(mslope3[0])+"x+"+str(mslope3[1])+"\nThese meet at ("+str(md[0])+", "+str(md[1])+")")
      aslope1=[-1/slope1[0],y3-(-x3/slope1[0])]
      aslope2=[-1/slope2[0],y1-(-x1/slope2[0])]
      aslope3=[-1/slope3[0],y2-(-x2/slope3[0])]
      orth=meetingpoint(aslope1, aslope2)
      print("PART 3: Orthocenter\nAltitude 1: y="+str(aslope1[0])+"x+"+str(aslope1[1])+"\nAlitude 2: y="+str(aslope2[0])+"x+"+str(aslope2[1])+"\nAltitude 3: y="+str(aslope3[0])+"x+"+str(aslope3[1])+"\nThese meet at ("+str(orth[0])+", "+str(orth[1])+")")
      if crcm == md and md == orth:
        print("Since these coordinates make an equilateral triangle, there is no Euler's line.")
      else:
        if crcm == md:
          eulerline=equation(md[0], md[1], orth[0], orth[1])
        else:
          eulerline=equation(crcm[0], crcm[1], md[0], md[1])
        print("The Euler line is y="+str(eulerline[0])+"x+"+str(eulerline[1]))