letters=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
with open('sixletter.txt', 'w') as fi:
  for a in letters:
    for b in letters:
      for c in letters:
        for d in letters:
          for e in letters:
            for f in letters:
              print(a+b+c+d+e+f)
              fi.write(a+b+c+d+e+f+'\n')