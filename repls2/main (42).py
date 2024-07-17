q=open("times.txt", "a")
qw=open("times.txt", "r")
if(qw.read()==""):
  print("You have run this program 1 time!")
  q.write("2")
  q.close()
else:
  qw=open("times.txt", "r")
  print("You have run this program", qw.read(), "times!")
  qw=open("times.txt", "r")
  EAsport=int(qw.read())
  q=open("times.txt", "w")
  q.write(str(EAsport+1))
  q.close()
