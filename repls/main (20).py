def nextinstanceoftrue(list,ind):
  if ind+1==len(list):
    p=0
  else:
    p=ind+1
  while not list[p]:
    if p+1==len(list):
      p=0
    else:
      p+=1
  return p
for i in range(1,int(input("Up to what?"))+1):
  t=[]
  for l in range(0,i):
    t.append(True)
  u=0
  while t.count(True)>1:
    b=nextinstanceoftrue(t,u)
    t[b]=False
    u=nextinstanceoftrue(t,b)
  print(t.index(True)+1)
#1 odd, 2 odd, 4 odd, 8 odd, 16 odd
