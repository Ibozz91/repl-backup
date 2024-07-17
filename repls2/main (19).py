from mpmath import mp
import os
mp.dps = 25
score = 0
h = mp.sqrt(2)
q = ""
while q != "n" and q != "no":
  lost = False
  while not lost:
    if mp.dps - 2 == score:
      mp.dps += 25
      h = mp.sqrt(2)
    if (input("") == str(h)[score:score + 1]):
      score += 1
    else:
      print("Wrong! The next number of sqrt2 was " +
                  str(h)[score:score + 1] + ". Your score was " +
                  (str(score - 1) if score > 1 else str(score)))
      score = 0
      lost = True
  q = input("Do you want to play again?")
  os.system("clear")