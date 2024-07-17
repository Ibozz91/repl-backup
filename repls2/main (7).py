#Hello player! If you are trying to play this game and have accidentally gotten here, try visiting https://replit.com/@Ibozz92/NARF2?v=1. You're welcome.
from decimal import *
def huckle(WrongMessage, num):
  print(WrongMessage)
  if num==0:
    print("You drink the juice for the first time. You start to feel weaker.")
  else:
    print("You drink another bottle. Everything starts to fade. Right before you die, an unknown person comes and tells you to go to the green triangle, whatever that means.")
    exit(0)
c=0
dt=0
lol=True
try:
  c=int(input("NARF 2\nA school project by Ian Bozzuto.\n(1) Start\n(2) How to play\n(3) Learn More\n"))
except ValueError:
  print("Please type a number.")
  lol=False
while c<1 or c>3:
  if lol:
    print("Please select 1, 2, or 3.")
  else:
    lol=True
  try:
    c=int(input(""))
  except ValueError:
    print("Please type a number.")
    c=0
    lol=False
if c==2:
  print("Several trivia questions will be given to you by the punishment master. Type in the correct answer and press enter. If you get a trivia question wrong you have to drink a bottle of huckleberry juice. If you drink two bottles, it's game over for you.")
elif c==3:
  print("The United Nations plans on having clean and affordable energy worldwide by the year 2030. This is one of their 17 Sustainable Development goals that they have.")
#Seems like you scrollled down a bit. No Peeking! Do not get spoilers.
h=0
print("I am the punishment master! I have decided that forcing people to compete is not the best way to do things. Instead, I am competing with you! I am choosing affordable and clean energy as my topic this time after spinning my old punishment wheel. Ironic, since I use coal energy here! Answer my questions or drink my huckleberry juice, and then I might install more coal!\nQUESTION 1:\nWhat percentage of the human population do not have any electricity? (You must be accurate within 10%)")
p=True
while p:
  try:
    n=Decimal(input(""))
  except InvalidOperation:
    print("Please enter a decimal.")
  else:
    p=False
print("The correct percentage is "+str(Decimal(100)*(Decimal(789000000)/Decimal(7900000000)))+"%. You were ", end="")
if Decimal(abs((n/Decimal(100))-(Decimal(789000000)/Decimal(7900000000))))<=0.1:
  print("correct!")
else:
  print("wrong!")
  huckle("The punishment master is pitiful of you getting it wrong on the first try.", dt)
  dt=1
print("QUESTION 2:\nWhat percentage of our energy is renewable? This time, you must be accurate to 5%.")
p=True
while p:
  try:
    n=Decimal(input(""))
  except InvalidOperation:
    print("Please enter a decimal.")
  else:
    p=False
if abs(n-Decimal(17))<=5:
  print("It was 17%! Good job.")
else:
  huckle("WRONG! It was SEVENTEEN PERCENT! SEVENTEEN PERCENT! EX VI EYE EYE!", dt)
  dt=1
print("QUESTION 3:\nHow much CO2 did we emit in 2021 in billion metric tons? Must be accurate to 10 billion metric tons.")
p=True
while p:
  try:
    n=Decimal(input(""))
  except InvalidOperation:
    print("Please enter a decimal.")
  else:
    p=False
if abs(n-Decimal(36.4))<=10:
  print("It was 36.4! Good job! (wait that's actually pretty alarming)")
else:
  huckle("It was 36.4. Why. Why must you do this.", dt)
  dt=1
x=input("QUESTION 4:\nThis one is pretty easy.\nAll you have to do is name a singular form of renewable energy.\n")
if x.lower() in ["nuclear", "nucular", "nuculer", "nucyular", "fission", "fision", "nuclear fission", "nuclear fision", "nucular fission", "nuculer fission", "nucular fision", "nuculer fission", "atom splitting", "solar", "sollar", "sun", "sunny", "sunny power", "nuclear power", "solar power", "soller power", "solar powar", "soler", "soller power", "solar panels", "solar roof", "solar panel", "wind", "wind power", "windmill", "windmill power", "windmills", "the white thing with three pointy things", "hydroelectric", "hydro", "hydro power", "hydroelectric power", "hidro", "water", "water power", "wind powerd", "wind powered", "hydro powered", "hydroelectric powered", "water powered", "fusion", "fusion power", "fusion powered", "nuclear fusion", "nuclear fusion power", "nuclear fusion powered", "fussion", "fussion power", "nuclear fussion", "heat", "heat power", "heat powered", "geothermal", "geothermal power", "geothermal powered", "geothermel"]:
  print("That is correct.")
else:
  huckle("You seriously couldn't come up with ONE FORM? Time for the juice!", dt)
  dt=1
print("HALFTIME SHOW! NARF now has halftime shows.\nThis halftime show features rick astley! *Imagine Never Gonna Give you Up in your head*\nQUESTION 5:\nHow many billion tonnes do we have left of our carbon budget in a 1.5℃ scenario? Must be accurate to 30 billion tonnes.")
p=True
while p:
  try:
    n=Decimal(input(""))
  except InvalidOperation:
    print("Please enter a decimal.")
  else:
    p=False
if abs(n-Decimal(313))<=30:
  print("Yep! 313! It's decreasing rapidly! itsallok itsallok itsallok itsallok")
else:
  huckle("It was 313, or CCCXIII.", dt)
  dt=1
y=input("QUESTION 6:\nWhat city in Europe is where the agreement to not have the Earth heat up 2 degrees Celsius happened?\n").lower()
if y == "paris":
  print("Correct, sorry I had to include a city in Fr*nce")
elif y == "montreal":
  huckle("Nope. But I get your confusion. Paris", dt)
  dt=1
else:
  huckle("NOPE. Paris", dt)
  dt=1
print("Penultimate question: What percentage of people in Sub-Saharan Africa do not have electricity? Must be accurate to 5%.")
p=True
while p:
  try:
    n=Decimal(input(""))
  except InvalidOperation:
    print("Please enter a decimal.")
  else:
    p=False
if abs(n-Decimal(51.42))<=5:
  print("Yes! 51.42%. I used Bayes' theorem for this.")
else:
  huckle("It was 51.42, or WAITROMANNUMERALSCANONLYREPRESNTNATURALNUMBERS", dt)
  dt=1
if input("FINAL QUESTION\n"+("You better get this right." if dt==1 else "You are safe now.")+"\nWhich renewable form of energy was used for the most energy in 2020?\n").lower() in ["hydroelectric", "hydro", "hydro power", "hydroelectric power", "hidro", "water", "water power", "hydro powered", "hydroelectric powered", "water powered"]:
  print("You won! GG.")
else:
  huckle("HYDRO! Hy-dro! You HAD to screw up on the last question. You HAD to.", dt)
  dt=1
if input("Wait, before you go... can you give 50 digits of e?\n") == "2.71828182845904523536028747135266249775724709369995":
  print("Wait, you do? The punishment master falls over and the vine boom sound efffect plays 50 billion times. Later, you hear that he is using solar power now.\nTRUE ENDING\nThanks for playing!")
else:
  print("ZAD. You do not know 50 digits of e. Okay, walk out of the dungionment. Nope, that's the Fire Exit. Yeah, right there. Bye.")