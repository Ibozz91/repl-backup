import math
def primes(x):
  lis=[]
  for i in range(x+1):
    b=True
    if i<2:
      b=False
    for n in lis:
      if n>int(math.sqrt(i)):
        break
      if i%n == 0:
        b=False
        break
    if b:
      lis.append(i)
  return lis
def primes2(x):
  lis=list(range(2,x+1))
  for i in range(len(lis)):
    if i >= len(lis):
      break
    f=lis[i]
    while f<=x:
      f+=lis[i]
      lis.remove(f)
  return lis
print(primes(69420))