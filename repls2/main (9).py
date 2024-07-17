def pascal(n):
  x=[]
  x.append(1)
  for i in range(0, len(n)-1):
    x.append(n[i]+(n[i+1]))
  x.append(1)
  return x
def highestpascal(int):
  n=[1]
  for i in range(0, int):
    n=pascal(n)
  return max(n)
for ia in range(0, int(input())):
  print(highestpascal(int(input())))