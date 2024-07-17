import math
def isnarcissistic(num,base):
  if(num<base):
    return False
  digits=math.floor(math.log(num,base))+1
  digitstopower=[]
  for i in range(digits,0,-1):
    digitstopower.append(math.floor((num%math.pow(base,i))/math.pow(base,i-1)))
  tosum = [int(math.pow(i, digits)) for i in digitstopower]
  return sum(tosum)==num
with open("a.txt", "w") as b:
  for j in range(3, 100):
    b.write("base "+str(j)+": \n")
    for i in range(1, 100000):
      if(isnarcissistic(i,j)):
        b.write(str(i)+"\n")