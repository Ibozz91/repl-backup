from mpmath import mp
def Goldbach(n):
  for i in range(2,int(n/2)+1):
    if mp.isprime(n-i) and mp.isprime(i):
      return str(n-i)+"+"+str(i)
  return "None"
x=int(input("Up to which number?"))
with open("gb"+str(x)+".txt", "w") as b:
  for i in range(4,x+2,2):
    b.write(str(i)+"="+Goldbach(i)+"\n")