import networkx as nx
from mpmath import *
import matplotlib.pyplot as plt
def primegraph(num):
  G=nx.Graph()
  for i in range(1,num+1):
    G.add_node(i)
  for i in range(1,num+1):
    for j in range(i+1,num+1):
      if mp.isprime(i+j):
        G.add_edge(i, j)
  return G
nx.draw(primegraph(20), with_labels=True, font_weight='bold')
plt.show()
'''
for i in range(4,20):
  G=primegraph(i)
  a = sorted(list(nx.simple_cycles(G)), key = lambda s: len(s))
  print(a[-1],"length",len(a[-1]),"for",i)
'''