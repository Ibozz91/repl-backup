x=int(input("Enter a number\n"))
seq=[]
while (not x in seq) and (x!=1):
  seq.append(x)
  factors=[]
  for i in range(1,x):
    if x%i==0:
      factors.append(i)
  s=""
  for j in range(0,len(factors)):
    if j<len(factors)-1:
      s+=str(factors[j])+"+"
    else:
      s+=str(factors[j])
  print(str(x)+">"+s+">"+str(sum(factors)))
  x=sum(factors)
print(seq)