from mpmath import mp

mp.dps = 25
score = 0
h = mp.e
q = ""
while q != "y" or q != "yes":
    lost = False
    print("Time for e memorization game!")
    while not lost:
        if mp.dps - 2 == score:
            mp.dps += 25
            h = mp.e
        if (input("") == str(h)[score:score + 1]):
            score += 1
        else:
            print("Wrong! The next number of e was " +
                  str(h)[score:score + 1] + ". Your score was " +
                  (str(score - 1) if score > 1 else str(score)))
            score = 0
            lost = True
    q = input("Do you wanna play again?")
