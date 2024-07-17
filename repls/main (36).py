import math
from mpmath import mp
import decimal
mp.dps = 15; mp.pretty = True
def step(num,base):
  digits=math.floor(mp.log(num,base))+1
  digitstopower=[]
  for i in range(digits,0,-1):
    digitstopower.append(math.floor((num%math.pow(base,i))/math.pow(base,i-1)))
  return sum([int(math.pow(i, 2)) for i in digitstopower])
with open("b.txt", "w") as b:
  for i in range(10, 11):
    b.write("Base "+str(i)+":\n")
    loops=[]
    numberinloops=[]
    totalhappy=0
    totalsad=0
    for j in range(1, 100001):
      x=j
      seq=[]
      while (not x in seq) and (x!=1):
        seq.append(x)
        x=step(x,i)
      if(x==1):
        totalhappy=totalhappy+1
      else:
        totalsad=totalsad+1
        thisloop=seq[seq.index(x):]
        if(thisloop in loops):
          numberinloops[loops.index(thisloop)]=numberinloops[loops.index(thisloop)]+1
        else:
          loops.append(thisloop)
          numberinloops.append(1)
    b.write("Happy density: "+str(totalhappy/(totalhappy+totalsad))+"\nTotal amount of loops: "+str(len(loops))+"\nLoops:\n")
    loopsum=sum(numberinloops)
    for p in range(0, len(loops)):
      b.write(str(loops[p])+": Ratio of sad numbers going into this loop: "+str(numberinloops[p]/loopsum)+"\n")
    print("base "+str(i)+" finished")