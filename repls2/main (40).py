from mpmath import mp
mp.dps=int(input("How many digits do you want? "))+1; mp.pretty = True
print(str(mp.power(mp.power(mp.pi,mp.e),mp.sqrt(2)))[:-1])