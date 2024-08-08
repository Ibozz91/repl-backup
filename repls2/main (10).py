import time
from random import randint
e="thing"
while True:
  print("\"Let's make a "+e+"!\", the "+e+" inventor said.")
  e=e+" inventor"
  time.sleep(1)
  if(randint(1, 100)==100):
    break
print("By the way, where the ████ are we?")