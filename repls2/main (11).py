import random
import time
# Variables
School = ["school", "homework", "teacher", "book", "backpack", "calculator", "lunchbox", "folder", "computer", "pencil"]
Summer = ["summer", "swimming", "beach", "warm", "hot", "green", "sunscreen", "camping", "relax", "vacation"]
Winter = ["winter", "skiing", "sleding", "cold"]
Camping = ["camping", "campfire", "marshmello", "hiking", "forest", "natural", "outdoors", "tent", "scenery", "trailer", "wildlife"]
House = ["house", "bedroom", "bathroom", "basement", "chimney", "door", "furniture", "garage", "garden", "closet", "kitchen", "painting", "stairs"]
themes = School, Summer, Winter, Camping, House
theme = random.choice(themes)
words = theme
theme_name = theme.__getitem__(0)
word = random.choice(words)
guess = ""
out_of_guesses = False
guesses = 0
display_list_guesses = []
display_list = word
word_display = word
noshows = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
           "w", "x", "y", "z", ".", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
           "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"]
incorrectguesses=[]
you_win = False
running_display2 = True
print("This is a modified version of hangman by @RemyBozung. Would you like to see the changes?")
changes=input("")
if changes=="Yes" or changes=="yes" or changes=="Y" or changes=="y":
  print("\n-Removed the blank word\n-Added a changelog\n-Changed the welcome message\n-Fixed the \"-1 guesses left\" bug\n-Changed \"You have already guessed that!\" to \"Invalid move!\"\n-Fixed the guessing again bug\n-Made it so that it will not remove 1 from guesses if you guessed the same incorrect letter twice\n-Made it so that it will terminate immediately after guessing the world\n-Made it so that it will state your incorrect guesses at the beginning of your turn\n-Made it so that it will state the word if you lose")

print("\nHere are the rules:\nYou will be asked to insert a letter of your choice, you will then be told if your letter was in the word or not!\nGuess all letters to win!\n")

# figures out if game is over and gets guess if not

while out_of_guesses == False:
    guesses_left = 7 - guesses
    if you_win == False:
        if guesses > 7:
            out_of_guesses = True
        else:
                word_display = display_list.replace(noshows.__getitem__(0), "-").replace(noshows.__getitem__(1),
                                                                                         "-").replace(
                noshows.__getitem__(2), "-").replace(noshows.__getitem__(3), "-").replace(noshows.__getitem__(4),
                                                                                              "-").replace(
                noshows.__getitem__(5), "-").replace(noshows.__getitem__(6), "-").replace(noshows.__getitem__(7),
                                                                                              "-").replace(
                noshows.__getitem__(8), "-").replace(noshows.__getitem__(9), "-").replace(noshows.__getitem__(10),
                                                                                              "-").replace(
                noshows.__getitem__(11), "-").replace(noshows.__getitem__(12), "-").replace(noshows.__getitem__(13),
                                                                                                "-").replace(
                noshows.__getitem__(14), "-").replace(noshows.__getitem__(15), "-").replace(noshows.__getitem__(16),
                                                                                                "-").replace(
                noshows.__getitem__(17), "-").replace(noshows.__getitem__(18), "-").replace(noshows.__getitem__(19),
                                                                                                "-").replace(
                noshows.__getitem__(20), "-").replace(noshows.__getitem__(21), "-").replace(noshows.__getitem__(22),
                                                                                                "-").replace(
                noshows.__getitem__(23), "-").replace(noshows.__getitem__(24), "-").replace(noshows.__getitem__(25),
                                                                                                "-").replace(
                noshows.__getitem__(26), "-")
        if not word_display.__contains__("-"):
          you_win = True
          continue
        print("Here is your word: " + word_display)
        print("The theme is: " + theme_name + "!")
        print("You have " + (guesses_left+2).__str__() + " guesses left")
        print("Your incorrect guesses are",incorrectguesses)
        guess = input("Your guess (1 letter): ")
        print("")
        if (not noshows.__contains__(guess)) or incorrectguesses.__contains__(guess):
            print("Invalid move!")
            continue
        if out_of_guesses == False:
            if word.__contains__(guess):
                display_list_guesses.append(guess)
                none_of_these = False
                noshows.remove(guess)
            else:
                print("There are no " + guess + "'s! Try again!")
                print("")
                incorrectguesses.append(guess)
                none_of_these = True
                guesses += 1


        else:
          print("Game over. The word was " + word + ".")
    else:
        print("")
        print("You win! The word was " + word + "!")
        out_of_guesses = True