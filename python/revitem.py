#Write a function which reverses each item in a list and return the new list.

def reverse_item(y):
    revitems = [x[::-1] for x in y]
    return revitems

user_input = input("Enter items separated by spaces: ")
items = user_input.split()
result = reverse_item(items)

print("Reversed list:", result)
