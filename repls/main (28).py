import os #pretty please?
from random import randint
import time
def fight(name, pname, php, hp, attack):
  turn=0
  e=hp
  p=php
  while True:
    print(pname+", you are at",p,"health!\n")
    print(name+" is at",e,"health.\n")
    if(e<=0):
      return True
    if(p<=0):
      return False
    if(turn==0):
      print(name+" attacks and deals",attack,"damage!\n")
      p=p-attack
    else:
      ewe=randint(1,100)
      print("You deal",ewe,"damage.\n")
      e=e-ewe
    if(turn==0):
      turn=1
    else:
      turn=0
    time.sleep(3)
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
qqq=True
if not(os.path.isfile("./savedata.txt")):
  print("Hello! Either this is your first time running, or you've gone and deleted your save data. Creating save data file...\n")
  with open("savedata.txt", "w") as f:
    n=input("What do you want your name to be?\n")
    f.write(n+"\n1")
  i=1
  print("Great! Let's start!\n")
else:
  with open("savedata.txt", "r") as f:
    t=1
    n=""
    for w in f.read():
      if(t==1):
        if(w=="\n"):
          t=2
        else:
          n=n+w
      else:
        i=int(w)
print("Welcome back, "+n+"! You are at level",i,"\n")
if(i==1):
  if(fight("lll", n, 100, 600, 5)==True):
    print("You won!\n")
    with open("savedata.txt", "w") as qqqq:
      qqqq.write(n+"\n2")
    i=2
  else:
    print("You lost.")
if(i==2):
  if(fight("final boss", n, 100, 100, 49)==True):
    print("You won the game! GG.\n")
    with open("savedata.txt", "w") as rrt:
      rrt.write(n+"\n3")
  else:
    print("You lost.")
elif(i>2 and i<9):
  print("Um... you won. Nothing to see here.\n")
  with open("savedata.txt", "w") as iopo:
    geer=str(i+1)
    iopo.write(n+"\n"+geer)
else:
  os.remove("savedata.txt")
  print("so long save data")