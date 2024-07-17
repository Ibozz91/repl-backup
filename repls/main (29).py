def SPAV(cands, votes, winners):
  m=0
  elected=[]
  while len(elected)<winners:
    m+=1
    print("ROUND "+str(m))
    votetotals=[]
    for p in cands:
      votetotals.append(0)
    for j in votes:
      hui=1
      for kl in elected:
        if kl in j:
          hui+=1
      for t in j:
        if not t in elected:
          votetotals[cands.index(t)]+=1/hui
    for z in range(0, len(votetotals)):
      print(cands[z]+": "+str(votetotals[z])+" votes")
    elected.append(cands[votetotals.index(max(votetotals))])
  return elected