import random
h=0
t=0
x=int(input("Please enter amount of trials "))
for i in range(x):
  if(random.randint(0,1)==0):
    h+=1
  else:
    t+=1
print("Out of "+str(x)+" coin tosses\n"+str(h)+" were heads\n"+str(t)+" were tails\n"+str((h/x)*100)+"% was heads\n"+str((t/x)*100)+"% was tails")