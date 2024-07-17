import math
import copy
def primes(n):
  prime = []
  for i in range(2,n+1):
    prime.append(i)
  for i in range(0,n-1):
    if i>=prime.__len__() or prime[i]>math.sqrt(n):
      break
    primea=copy.deepcopy(prime)
    for j in range(i,n):
      if prime[j]>=prime.__len__() or prime[i]*prime[j]>n:
        prime=copy.deepcopy(primea)
        break
      if prime[i]*prime[j] in prime:
        primea.remove(prime[i]*prime[j])
  return prime
print(primes(100000))