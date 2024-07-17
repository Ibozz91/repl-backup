import urllib.request
#import pathlib
#import webbrowser
import os
hhgregg=input("Enter a website\n")
os.system('clear')
print(urllib.request.urlopen(hhgregg).read())
#with open("website.html", "w") as f:
#  f.write(str(urllib.request.urlopen(hhgregg).read()))
#webbrowser.open(str(pathlib.Path(__file__).parent.absolute())+"website.html")