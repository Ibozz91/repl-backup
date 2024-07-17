import random
valid_chars="QWERTYUIOPASDFGHJKLZXCVBNMMqwertyuiopasdfghjklzxcvbnm1234567890~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/ "
pswrd=""
custom=input("Currently valid chars are all typable on a keyboard.\n Do you want to use a different set of characters?")
if(custom.lower()=="yes" or custom.lower()=="y"):
  valid_chars=input("Please put an input of the characters you want to use:\n")
maxl=int(input("What is the length you would like to use?"))
while(len(pswrd)<maxl):
  pswrd=pswrd+random.choice(valid_chars)
print(pswrd)