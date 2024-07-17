import random
import statistics
results=[]
for i in range(0, 1000000):
  print(i)
  pot=2
  while random.randint(0,1) != 1:
    pot=pot*2
  results.append(pot)
print("Result: "+str(statistics.mean(results)))