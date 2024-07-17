def hex1(x):
  return hex(x)[2:]
def solve(start,digits):
  if(len(hex1(start))==15):
    print("solution found: "+str(start))
    file = open("solutions.txt", "a")  # append mode
    file.write(hex1(start)+"\n")
    file.close()
  else:
    for i in digits:
      if (not i in hex1(start)) and ((start*16+int(i,16))%(len(hex1(start))+1)==0):
        print(hex1(start*16+int(i,16)))
        solve(start*16+int(i,16),digits)
for i in range(1,16):
  solve(int(hex1(i),16), ["1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"])