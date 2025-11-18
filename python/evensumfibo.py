#Find the sum of even valued terms in a fibonacci series

n = int(input("Enter n(number of elements): "))
a, b = 0, 1
sum=0
if n <= 0:
    print("Invalid")

elif n == 1:
    print(a)
    print("No value to add")

elif n == 2:
    print(a, b)
    print("No value to add")

else:
    print(a, b, end=" ")
    
    arr = [a, b]           
    for i in range(n - 1):
        a, b = b, a + b
        print(b, end=" ")
        if(b%2==0):
            sum+=b

print("\nSum of even valued terms:",sum)
    

