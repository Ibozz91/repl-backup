x=int(input("how many numbers"))
free=[]
for i in range(1,x+1):
  free.append(i)
tax=[]
you=[]
hasdivisor=True
while hasdivisor:
  print("Free: "+str(free)+"\nTaxman: "+str(tax)+"\nYou: "+str(you))
  t=True
  while t:
    y=int(input("Enter a number to use"))
    if y not in free:
      print("You can't choose this number")
    else:
      toremove=[]
      for i in range(0,free.index(y)):
        if y%free[i]==0:
          toremove.append(free[i])
      for h in toremove:
        free.remove(h)
        tax.append(h)
      if len(toremove)==0:
        print("No factors")
      else:
        free.remove(y)
        you.append(y)
        t=False
  hasdivisor=False
  for i in range(0,len(free)):
    for j in range(0,i):
      if free[i]%free[j]==0:
        hasdivisor=True
for p in free:
  tax.append(p)
print("Taxman: "+str(tax)+"\nYou: "+str(you))
print("Taxman score: "+str(sum(tax))+"\nYour score: "+str(sum(you)))
if sum(tax)>sum(you):
  print("Taxman won")
elif sum(you)>sum(tax):
  print("You won")
else:
  print("Tie")