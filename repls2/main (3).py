def bestamount(allowed, g):
  l=list(allowed)
  l.insert(0,1)
  amount=[1]
  for i in range(2, g+1):
    if i in l:
      amount.append(1)
    else:
      pq=g+1
      for fg in l:
        if fg<i and amount[i-fg-1]+1<pq:
          pq=amount[i-fg-1]+1
      amount.append(pq)
  return amount
print(bestamount([1,4,9,16,25,36,49],100))