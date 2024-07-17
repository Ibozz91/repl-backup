from time import time
import math
import os
os.environ['TZ'] = 'Universal'
'''
1 decond = 1/100 dinute
1 dinute = 1/100 dour
1 dour = 1/10 day
1 day = 1 SI day
1 dear = 100 days
'''
x=int(input("Do you want:\n1: To input a time\n2: To use the current time\n"))
if x==1:
  t=int(input("Input the amount of seconds from 1970\n"))
else:
  t=time()
y=math.floor(t/8640000)
d=math.floor(t/86400-(y*100))
h=math.floor(t/8640-(y*1000)-(d*10))
m=math.floor(t/86.4-(y*100000)-(d*1000)-(h*100))
s=math.floor(t/0.864-(y*10000000)-(d*100000)-(h*10000)-(m*100))
print(f"{h}:{m}:{s} {d}/{y}")