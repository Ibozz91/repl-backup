import time
import os
os.environ['TZ'] = 'Universal'
time.tzset()
if time.strftime('%a') == 'Wed':
  print('It is wednesday my dudes')
else:
  print('It is not wednesday my dudes')