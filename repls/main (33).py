def howmanyways(total,valid,things,last=-1):
  if last == -1:
    last = max(valid)
  if total==0:
    return 1
  if (total,last) in things:
    return things[(total,last)]
  howmanyways(total-1,valid,things,last)  
  h=0
  for i in valid:
    if i<=total and i<=last:
      h+=howmanyways(total-i,valid,things,i)
  things[(total,last)]=h
  return h
dict={}
valid=[1,2,4,6,10,20,40,50,100,200]
print(howmanyways(200,valid,dict))