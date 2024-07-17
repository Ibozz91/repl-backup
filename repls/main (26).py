def solve(start,digits):
  if(len(str(start))==9):
    print("solution found: "+str(start))
    file = open("solutions.txt", "a")  # append mode
    file.write(str(start)+"\n")
    file.close()
  else:
    for i in digits:
      if (not i in str(start)) and ((start*10+int(i))%(len(str(start))+1)==0):
        print(start*10+int(i))
        solve(start*10+int(i),digits)
for i in range(1,10):
  solve(i, ["1", "2", "3", "4", "5", "6", "7", "8", "9"])