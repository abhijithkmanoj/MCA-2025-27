#find sum of all elements in a list
sum=0
a=list(map(int,input("enter elemnts of the list:").split(",")))
print(a)
for i in a:
    sum+=i
print(sum)