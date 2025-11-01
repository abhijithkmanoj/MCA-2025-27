#3.	Write a program to search an item in a given list and display the number of occurrences of the given item. 
    

def search(list,x):
    c=0
    for i in range(0,len(list)):
        if(list[i]==x):
            c=c+1
    return c


l1=list(map(int,input("Enter numbers of the list comma seperated:").split(",")))

a=int(input("Enter element to search:"))
print(search(l1,a))

