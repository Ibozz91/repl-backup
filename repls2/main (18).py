alphabet=["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
for i in range(0,int(input())):
  g=input()
  f=g.split("|")
  anagram=True
  if f[0]==f[1]:
    anagram=False
  if(len(f[0])==len(f[1])):
    for i in alphabet:
      if f[0].count(i)!=f[1].count(i):
        anagram=False
  else:
    anagram=False
  ty="NOT AN ANAGRAM"
  if anagram:
    ty="ANAGRAM"
  print(g+" = "+ty)