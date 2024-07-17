nums = ['1','2','3','4','5','6','7','8','9','0']
with open("t.txt", "r") as f:
  vals=[]
  for x in f:
    num=[0,0]
    curnum=1
    for h in x:
      if h in nums:
        if curnum==1:
          num[0]=int(h)
        num[1]=int(h)
    vals.append(num[0]*10+num[1])
  print(sum(vals))