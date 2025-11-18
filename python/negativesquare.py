 
#check whether a given positive integer is power of 2. Raise exception for negative input.

def is_power_of_two(n):
    if n < 0:
        raise ValueError("Negative numbers are not allowed.")
    if n == 0:
        return False
    
    
    while n % 2 == 0:   
        n = n // 2
        if n == 1:
            return True

    return False   


try:
    num = int(input("Enter a positive integer: "))
    if is_power_of_two(num):
        print(f"{num} is a power of 2.")
    else:
        print(f"{num} is NOT a power of 2.")
except ValueError as e:
    print("Error:", e)


