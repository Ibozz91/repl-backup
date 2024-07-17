import os.path
from os import path
if(path.exists('file.txt')):
  f=open('file.txt', 'r')
  h=int(f.read())
  f.close()
  f=open('file.txt', 'w')
  f.write(str(h+1))
  f.close()
  print('This program has been run',h+1,'times!')
else:
  f=open('file.txt', 'w')
  f.write('1')
  f.close()
  print('This is the first time someone ran the program!')