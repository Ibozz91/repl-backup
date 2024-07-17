import math
for i in range(0, int(input())):
  y=int(input())
  for g in range(0, pow(2,y)):
    print("0"*(y-len(str(bin(g))[2:]))+str(bin(g))[2:])