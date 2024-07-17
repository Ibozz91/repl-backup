from mpmath import mp
h=input("What substring?\n")
mp.dps=len(h)+1
print("Searching...")
while not (str(mp.e()))[-(len(h)+1):][:-1] == h:
  mp.dps+=1
print("Found at "+str(mp.dps-len(h)))