    #     *
    #   *   *
    # *   *   *

n=int(input("Enter n(number of lines):"))
for i in range(1,n+1):
    print("   ",end=" "*(n-i))
    for j in range(0,i):
        print("*",end=" ")
    print("\n")