while True:
  i=int(input("Which number do you want to try? "))
  while True:
    if(i==1):
      print("And we got back to 1!")
      break
    elif(i%2==0):
      i=i/2
      print("We divide by 2 to get",i)
    else:
      i=(i*3)+1
      print("We multiply by 3 and add 1 to get",i)