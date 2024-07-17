def havetheywon(board, tester):
  for i in range(0,3):
    for n in range (0,3):
      if((i==0 and n==0 and board[0][0]==tester and board[1][1]==tester and board[2][2]==tester) or (i==0 and board[i][n]==tester and board[i+1][n]==tester and board[i+2][n]==tester) or (n==0 and board[i][n]==tester and board[i][n+1]==tester and board[i][n+2]==tester) or (i==0 and n==2 and board[0][2]==tester and board[1][1]==tester and board[2][0]==tester)):
        return True
  return False
for h in range(0, int(input())):
  x=input()
  board=[["_","_","_"],["_", "_", "_"],["_","_","_"]]
  for d in range(0,3):
    for y in range(0,3):
      board[d][y]=x[d*3+y:(d*3+y+1)]
  if(havetheywon(board,"X")):
    print(x+" = X WINS")
  elif(havetheywon(board,"O")):
    print(x+" = O WINS")
  else:
    print(x+" = TIE")