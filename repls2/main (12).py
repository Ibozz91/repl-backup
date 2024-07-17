import time
import os
from dateutil.zoneinfo import get_zonefile_instance
formats = ['%X %x %Z', 'Day %j of %Y', '%A, %B %d, %Y at %I:%M:%S %p', '%a, %b %d, \'%y at %I:%M:%S %p']
print("Formats:\n1: Simple With slashes, military time, and time zone\n2: Day of the year\n3: Names without abbrieviations\n4: Names with abbrieviations\n5: Custom")
format=int(input("Select a format "))
if format==5:
  add=input("Enter a strftime format ")
  formats.append(add)
os.system('clear')
print("I would reccomend time zone format Etc/GMT with the opposite sign")
print("e.g. If I wanted to do EST, I would type Etc/GMT+5")
tzlol=input("Set a time zone ")
if tzlol=="Oh, so you're a clock? Name every time zone":
  zonenames = list(get_zonefile_instance().zones)
  for i in zonenames:
    print(i)
  exit()
os.environ['TZ'] = tzlol
time.tzset()
os.system('clear')
while True:
  print(time.strftime(formats[format-1]))
  time.sleep(1)
  os.system('clear')