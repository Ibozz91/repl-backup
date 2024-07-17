import time
num=int(input('Input reps.'))
num2=int(input('Input rounds.'))
for i in range(0,num2):
  print('Round '+str(i+1))
  print('30 second break.')
  time.sleep(27)
  print('3...')
  time.sleep(1)
  print('2...')
  time.sleep(1)
  print('1...')
  time.sleep(1)
  for n in range(0,num):
    print(str(n+1)+'!')
    time.sleep(5)
print('You are done with your workout.')