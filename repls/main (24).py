import itertools
import numpy as np
def coinage(max, n, allowed=[]):
  if allowed==[]:
    allowed=list(range(1,max+1))
  if (not (1 in allowed)) or len(allowed)<=n:
    return [-1]
  allowed.remove(1)
  '''
  Ideas:
  Definitely use 1 cent
  How to find minimum?
  99 cents, given [1,3,96,97]?
  Not [97,1,1] but [96,3], this isn't like converting a base.
  Bruteforce??????
  This is kind of like Knapsack problem
  First, remove evrything above what you need
  Higher > Lower; [3, 96] would be same as [96, 3].
  Maybe try highest; go from there, recusion??? But if too long, abort
  '''
  best=[-1]
  bestamount=[-1]
  for tl in itertools.combinations(allowed, n-1):
    l=list(tl)
    l.insert(0,1)
    amount=[1]
    for i in range(2, max+1):
      if i in l:
        amount.append(1)
      else:
        pq=max+1
        for fg in l:
          if fg<i and amount[i-fg-1]+1<pq:
            pq=amount[i-fg-1]+1
        amount.append(pq)
    if bestamount==[-1] or np.sum(amount)<np.sum(bestamount):
      bestamount=amount
      best=l
  print(str(best)+" is representable using "+str(np.sum(bestamount))+" coins: "+str(bestamount))
  return best
coinage(100,5)