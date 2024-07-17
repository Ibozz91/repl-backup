import math
a=int(input("Length of first side"))
b=int(input("Length of second side"))
c=int(input("Length of third side"))
s=(a+b+c)/2
print(math.sqrt(s*(s-a)*(s-b)*(s-c)))