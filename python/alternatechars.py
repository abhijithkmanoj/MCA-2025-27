#Display alternate characters from a line of text using recursion.

def alternate_chars(text, index=0):

    if index >= len(text):
        return ""
    
    return text[index] + alternate_chars(text, index + 2)

line = input("Enter a line of text: ")

result = alternate_chars(line)
print("Alternate characters:", result)
