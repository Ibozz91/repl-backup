import copy
p=[0]
for i in range(0,10000):
  if p.index(p[i])==i:
    p.append(0)
  else:
    p.append(p[i-1::-1].index(p[i])+1)
print(p)