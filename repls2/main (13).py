from dateutil.zoneinfo import get_zonefile_instance
zonenames = list(get_zonefile_instance().zones)
for i in zonenames:
  print(i)