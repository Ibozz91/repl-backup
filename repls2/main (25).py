from operator import *
primes=[]
f=open("primefactors1mil.txt", "w")
for i in range(2, 1000001):
  primefactors=[]
  curnum=i
  iisprime=True
  for g in primes:
    while curnum%g==0:
      iisprime=False
      primefactors.append(g)
      curnum=curnum/g
  if iisprime:
    primes.append(i)
    primefactors.append(i)
  f.write(str(i)+":")
  for h in primes:
    if countOf(primefactors,h)>0:
      f.write(str(h))
      if countOf(primefactors,h)>1:
        f.write("^"+str(countOf(primefactors,h)))
      if h!=primefactors[len(primefactors)-1]:
        f.write("*")
  f.write("\n")
f.write(str(primes))
f.close()