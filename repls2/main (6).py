i=0
while True:
  b1=(i-7)%10==0
  b2=i%7==0
  if b1:
    print("Bizz", end="")
  if b2:
    print("buzz" if b1 else "Buzz", end="")
  if (not b1) and (not b2):
    print(i)
  else:
    print("")
  i+=1