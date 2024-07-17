import time
import os
os.environ['TZ'] = 'Universal'
time.tzset()
if (int(time.strftime('%Y')) % 4)==0 and ((not (int(time.strftime('%Y')) % 100)==0) or (int(time.strftime('%Y')) % 400)==0):
  d=366
else:
  d=365
print(time.strftime('%Y is ')+str((int(time.strftime('%j'))/d)*100))