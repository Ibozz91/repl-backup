import copy
import random
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
def Boardaftermove(boa, turn, move):
  board=copy.deepcopy(boa)
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
  return board
def Evalboard(board, turn, depth):
  if depth==0:
    margin=0
    for i in range(0,100):
      xscore=0
      oscore=0
      boardx=copy.deepcopy(board)
      turn1=turn
      ssp=0
      while ssp<2:
        h=legalmoves(boardx,turn1)
        if len(h)>0:
          boardx=Boardaftermove(boardx,turn1,random.choice(h))
          ssp=0
        else:
          ssp+=1
        turn1=not turn1
      for az in boardx:
        for za in az:
          if za=="x":
            xscore+=1
          elif za=="o":
            oscore+=1
      margin+=xscore-oscore
    margin=margin/100
    return margin
  else:
    u=legalmoves(board, turn)
    f=legalmoves(board, not turn)
    if len(u)==0 and len(f)==0:
      xscore=0
      oscore=0
      for az in board:
          for za in az:
              if za=="x":
                  xscore+=1
              elif za=="o":
                  oscore+=1
      return xscore-oscore
    elif len(u)==0:
      return Evalboard(board, not turn, depth-1)
    t=[]
    for p in u:
      t.append(Evalboard(Boardaftermove(board,turn,p),not turn, depth-1))
    if turn:
      return max(t)
    else:
      return min(t)
def Y(board, turn, depth):
  qwertyu=["a","b","c","d","e","f","g","h"]
  t=[]
  if len(legalmoves(board, turn))==0:
      print("Nothing lol")
  for p in legalmoves(board, turn):
    t.append(Evalboard(Boardaftermove(board,turn,p),not turn, depth-1))
  for h in range(0,len(t)):
    print(qwertyu[legalmoves(board, turn)[h][1]]+str(legalmoves(board, turn)[h][0]+1)+": "+str(t[h]))
Y([["-","-","-","-","-","-","-","-"],
  ["-","-","-","-","-","-","-","-"],
  ["-","-","x","-","-","-","-","-"],
  ["-","-","-","o","x","-","x","-"],
  ["-","-","x","x","o","-","x","-"],
  ["-","-","-","o","o","o","-","-"],
  ["-","-","-","o","-","-","o","-"],
  ["-","-","-","-","-","-","-","-"]],True,4)