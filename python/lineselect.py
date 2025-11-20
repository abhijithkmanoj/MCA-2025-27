#Write a program that retrieves all lines from a file having words starting with 's' and ending with 'e'

import re
pattern = r"\bs\w*e\b"

filename = input("Enter filename: ")

try:
    with open(filename, "r") as file:
        for line in file:
            if re.search(pattern, line, re.IGNORECASE):
                print(line.strip())
except FileNotFoundError:
    print("File not found!")
