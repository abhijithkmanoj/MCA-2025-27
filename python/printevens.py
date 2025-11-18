# 4.	Write a program to print all even numbers from a given list in the given order until you reach number 237 or end of the list. 


numbers = list(map(int, input("Enter numbers separated by space: ").split()))

for num in numbers:
    if num == 237:
        break  
    if num % 2 == 0:
        print(num)
