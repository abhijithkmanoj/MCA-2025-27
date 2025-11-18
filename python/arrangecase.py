#Arrange characters in a string such that lowercase letters must come first.

s = input("Enter a string: ")

lower = ""
upper = ""

for ch in s:
    if ch.islower():
        lower += ch
    else:
        upper += ch

result = lower + upper
print("Rearranged string:", result)
