#Given a string of odd length greater than 7, return a new string made of the middle threee characters of a given string.

s = input("Enter a string of odd length greater than 7: ")

if len(s) <= 7 or len(s) % 2 == 0:
    print("Invalid input! String length must be odd and greater than 7.")
else:
    mid = len(s) // 2             
    result = s[mid-1 : mid+2]     
    print("Middle three characters:", result)
