def fibb(n,dict={}):
  if n in dict:
    return dict[n]
  if n<=1:
    return n
  else:
    dict[n]=fibb(n-1,dict)+fibb(n-2,dict)
    return dict[n]
n=int(input())
print(fibb(n))