def legalmoves(board, turn):
  h=[]
  for p in range(0,8):
    for t in range(0,8):
      legal=False
      if board[p][t]=="-":
        for x in [-1, 0, 1]:
          for y in [-1, 0, 1]:
            if (not (x==0 and y==0)) and (0<=(p+x)<8) and (0<=(t+y)<8):
              p1=p+x
              t1=t+y
              m=False
              if turn:
                m=board[p1][t1]=="o"
              else:
                m=board[p1][t1]=="x"
              if m:
                while (0<=p1<8) and (0<=t1<8):
                  nextspace=board[p1][t1]
                  if turn:
                    if nextspace=="-":
                      break
                    elif nextspace=="x":
                      legal=True
                      break
                  else:
                    if nextspace=="-":
                      break
                    elif nextspace=="o":
                      legal=True
                      break
                  p1+=x
                  t1+=y
      if legal:
        h.append([p,t])
  return h
history=[]
board=["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"],["-","-","-","-","-","-","-","-"]
board[3][3]="o"
board[3][4]="x"
board[4][3]="x"
board[4][4]="o"
things=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","p","q","r","s","t","u","v","w","y","z","0","1","2","3","4","5","6","7","8","9"]
subseqpass=0
turn=True
while subseqpass<2:
  if turn:
    print("It is black's turn!")
  else:
    print("It is white's turn!")
  legals=legalmoves(board,turn)
  si=0
  for y in range(0,8):
    for v in range(0,8):
      print(board[y][v]+"   ", end="")
    print("\n")
  print("\n\n")
  for y in range(0,8):
    for v in range(0,8):
      if [y,v] in legals:
        print(things[si]+"   ", end="")
        si+=1
      else:
        print(board[y][v]+"   ", end="")
    print("\n")
  if si==0:
    print("There are no legal moves to make, so the turn must be passed.")
    turn=not turn
    subseqpass+=1
    history.append([-1,-1])
  else:
    subseqpass=0
    if si==1:
      print("There is only 1 legal move to make.")
      move=legals[0]
    else:
      t=True
      while t:
        u=input("Enter the letter of your turn.\n").upper()
        if 0<=things.index(u)<si:
          move=legals[things.index(u)]
          t=False
        else:
          print("Try again.")
    history.append(move)
    for x in [-1, 0, 1]:
      for y in [-1, 0, 1]:
        if (not (x==0 and y==0)) and (0<=(move[0]+x)<8) and (0<=(move[1]+y)<8):
          p1=move[0]+x
          t1=move[1]+y
          m=False
          if turn:
            m=board[p1][t1]=="o"
          else:
            m=board[p1][t1]=="x"
          if m:
            while (0<=p1<8) and (0<=t1<8):
              nextspace=board[p1][t1]
              if turn:
                if nextspace=="-":
                  break
                elif nextspace=="x":
                  p2=move[0]
                  t2=move[1]
                  while (p1!=p2) or (t1!=t2):
                    board[p2][t2]="x"
                    p2+=x
                    t2+=y
                  break
              else:
                if nextspace=="-":
                  break
                elif nextspace=="o":
                  p2=move[0]
                  t2=move[1]
                  while (p1!=p2) or (t1!=t2):
                    board[p2][t2]="o"
                    p2+=x
                    t2+=y
                  break
              p1+=x
              t1+=y
    turn=not turn
xscore=0
oscore=0
for az in board:
  for za in az:
    if za=="x":
      xscore+=1
    elif za=="o":
      oscore+=1
print("Final Score = "+str(xscore)+"-"+str(oscore)+".")
if xscore>oscore:
  print("Black wins!")
elif oscore>xscore:
  print("White wins!")
else:
  print("Draw.")
print("Results:")
qwertyu=["a","b","c","d","e","f","g","h"]
for lk in range(0,len(history)):
  if lk%2==0:
    print(str(int((lk+2)/2))+". ", end="")
  if history[lk][1]==-1:
    print("- ", end="")
  else:
    print(str(qwertyu[history[lk][1]])+str(history[lk][0]+1)+" ", end="")
print(str(xscore)+"-"+str(oscore))