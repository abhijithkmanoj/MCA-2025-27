#1.	Accept full name and display in reverse order with space between the words.
def revname(name):
    if not name: return''
    else: return name[-1]+revname(name[:-1])

name=input("Enter full name:")
a=revname(name)
print(a)