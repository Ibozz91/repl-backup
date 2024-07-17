import random
from random import randint
import time
print('Claiming The Rockland - a minor science project. Play WaveGame (NARF) on my other account @Ibozz92 for a game with more content.\n\nMade by Ian only, and in python this time \'cause I don\'t need to use objects or anything. press enter to continue.')
x=input('')
if(x=="uuddlrlrba"):
  print('Cheat code!')
  h=1
  while True:
    for i in range(0, h):
      print('h',h)
    h=h*2
print('\nYou wake up, and can only remember that you are a granitic gneiss called con. However, you, from your knowledge, know your amnesia will wear off and you will learn more about yourself! In the meantime, you see another gneiss\' will next to you saying you get all their crystals. You must be related! You have to get the crystals at the nearby castle, and there are some rocks in the way.')
f1hp=300
f1hpai=360
print('You are near a beach. Suddenly, a conglomerate comes to you! "I can be the heir to the crystals without YOU!" He doesn\'t seem very friendly.\n')
while True:
  print('CONGLOMERATE FIGHT\nYour hp: '+str(f1hp)+'\nConglomerate hp: '+str(f1hpai))
  att=int(input('Which attack do you want to do?\n1: Melting - certain 60 damage as magma\n2: Foliation - Random amount of bands attack - Random from 40 to 80\n'))
  if(att==1):
    f1hpai-=60
  else:
    qee=randint(40, 80)
    print(str(qee)+' hp of damage!')
    f1hpai-=qee
  if(f1hpai<=0):
    print('You beat the conglomerate! Good job')
    break
  qwertyu=randint(0,1)
  if(qwertyu==0):
    fdfs=randint(0,1)
    print('The conglomerate chose Fossils (They could be in the rock - either 100 damage, or none: 50/50), and ', end="")
    if(fdfs==0):
      print('deals no damage!')
    else:
      print('deals 100 damage!')
      f1hp-=100
  else:
    erty=randint(30,70)
    print('The conglomerate chose Erosion (attack as sediments, which gives random from 30 to 70 damage) and dealt '+str(erty)+' damage!')
    f1hp-=erty
  if(f1hp<=0):
    print('You got crushed! Dont give up; try again!')
    f1hp=300
    f1hpai=360
print('Here are the ways you were superior to that rock:\nYou don’t have any giant strata!\nTo make your type requires only one process (heat and pressure) not two (weathering and erosion + compaction and cementation)\nYou now start to learn more about yourself!\nYou were originally an igneous rock, which was melted magma/lava!\nYou were pushed together and heated by heat and pressure.\nYou continue to get to a volcano, and an obsidian is in your way! He knows he has to crush you to get your inheritance! He says, "Someone like me should get the will!" Fight! But then he says, "How about you answer my riddles, or get crushed!"\nAnswer with the first letter capitalized.')
while(True):
  print("If I were a Marble, and I went through weathering and erosion, what would I become?")
  if(input("")=="Sediment"):
    print("Correct!")
    break
  else:
    print('You got crushed! Dont give up; try again!')
while(True):
  print('What if I were magma, and I cooled down INSIDE the volcano? What rock would I become? (Do not put "rock" at the end)')
  if(input('')=="Intrusive igneous"):
    print("Correct!")
    break
  else:
    print('You got crushed! Dont give up; try again!')
while(True):
  yty=input('Finally, what would you become if you melted?\n')
  if(yty=="Magma" or yty=="Lava"):
    print("Correct!")
    break
  else:
    print('You got crushed! Dont give up; try again!')
print('Here are the ways you were superior to that rock:\nUnlike Obsidian, you are not all black!\nUnlike Obsidian, you are not smooth! (You do not like things smooth)\nYou now start to learn more about yourself!\nWhen you went through heat and pressure, you did it underground!\nYou have quartz! (Unless the real life rock I had that has quartz isn’t granitic gneiss)\nYou are nearby the castle! Suddenly, one of the guards (a Marble) says, "Guess what? I’ve been planning a military coup, and that starts with YOU!" He can also mirror your attacks, since he is also metamorphic.')
f3hp=400
f3hpai=400
while(True):
  print("MARBLE FIGHT\nYour hp: "+str(f3hp)+"\nMarble hp: "+str(f3hpai))
  if(int(input("Do you want to do:\n1: Crystals: Random damage from crystals, either 30, 40, or 70\n2: Foliation: Random amount of bands attack from 40 to 80\n"))==1):
    qqqq=[30, 40, 70]
    frt=random.choice(qqqq)
    print(str(frt)+" damage to the Marble!")
    f3hpai-=frt
    if(f3hpai<=0):
      print("You win! Good job!")
      break
    frt=random.choice(qqqq)
    print(str(frt)+" damage to you now!")
    f3hp-=frt
    if(f3hp<=0):
      print("You lost! Don't give up, try again!")
      f3hp=400
      f3hpai=400
      continue
  else:
    frt=randint(40, 80)
    print(str(frt)+" damage to the Marble!")
    f3hpai-=frt
    if(f3hpai<=0):
      print("You win! Good job!")
      break
    frt=randint(40, 80)
    print(str(frt)+" damage to you now!")
    f3hp-=frt
    if(f3hp<=0):
      print("You lost! Don't give up, try again!")
      f3hp=400
      f3hpai=400
      continue
print('Here are the ways you were superior to that rock:\nYou aren\'t all white and sparkly!\nYou now start to learn more about yourself!\nYou have feldspar.\nYou were (probably) formed from granite, an igneous rock!\nYou go in and get the crystals! You are now the absolute monarch of the land, and the richest in rockland!\nYour powers are:\nFiring everybody at the castle, and hiring new ones!\nBeing able to force people to work for little pay!\nBeing a good and kind ruler!\nInvading your enemies!\nSetting up a dynasty for who gets the throne next!\nFaking your death, then going into the grass and being forgotten about... wait a minut-\nCREDITS: Made by Ian, and Ian only. The end.')
time.sleep(5)
while(True):
  print("Oh, you're still here? Well, I'll give you something to do! You can play Rock, Paper, Scissors with one of your servants! RPG, more like RPS amirite? Choose!")
  x=input("")
  if(x.lower()=="rock"):
    print("Your servant chose rock, you tied!")
  elif(x.lower()=="paper"):
    print("Your servant chose rock, you won!")
  elif(x.lower()=="scissors"):
    print("Your servant chose rock, you lost!")
  else:
    print("Your servant chose rock, you made him get confused as to what you were making!")