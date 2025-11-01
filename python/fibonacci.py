n=int(input("Enter n(number of elements):"))
a,b=0,1
if(n<=0):
    print("Invalid")
elif(n==1):
    print(a)
elif(n==2):
    print(a,b)
else:
    print(a,b,end=" ")
    for i in range(1,n-1):
        a,b=b,a+b
        # a=b
        # b=a+b
        print(b,end=" ")