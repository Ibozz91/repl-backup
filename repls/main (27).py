from mpmath import *
def goldbach(n):
  for i in range(2,int(mp.floor(n/2)+1)):
    if mp.isprime(i) and mp.isprime(n-i):
       return [i, n-i]
i=4
f = open("results.txt", "w")
while(True):
  print(i)
  r=goldbach(i)
  f.write(str(r[0])+"+"+str(r[1])+"="+str(i)+"\n")
  i+=2