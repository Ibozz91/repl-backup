import math
from decimal import *
votes=[]
seats=[]
votepercent=[]
seatpercent=[]
dif=[]
for i in range(0,int(input("How many political parties?\n"))):
  votes.append(Decimal(input("How many votes did this party get?\n")))
  seats.append(Decimal(input("How many seats did this party get?\n")))
for p in votes:
  votepercent.append(p*100/sum(votes))
for h in seats:
  seatpercent.append(h*100/sum(seats))
for o in range(0, len(votes)):
  dif.append(math.pow(votepercent[o]-seatpercent[o],2))
print("The Gallagher index is "+str(math.sqrt(sum(dif)/2))+".")