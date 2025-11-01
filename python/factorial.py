fact=1
n=int(input("Enter number to find factorial:"))
if(n<=0):
    print("Invalid")
else:
    for i in range(1,n+1):
        fact=fact*i
print("Factorial=",fact)