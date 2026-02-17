k=int(input())
l=list(map(int,input().split()))
print(((sum(set(l))*k)-sum(l))//(k-1))