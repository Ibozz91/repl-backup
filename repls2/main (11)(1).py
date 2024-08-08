import networkx as nx
from mpmath import *
import matplotlib.pyplot as plt
def collatz(num):
  if num%2==0:
    return int(num/2)
  else:
    return num*3+1
def collatzadd(g, num, oneused=False):
  if num==1:
    if oneused:
      return
    else:
      oneused=True
  else:
    g.add_edge(num,collatz(num))
    collatzadd(g,collatz(num),oneused)
g=nx.DiGraph()
for i in range(1,40):
  collatzadd(g,i)
nx.draw(g, with_labels=True, font_weight='bold')
plt.savefig("collatz_40.png")