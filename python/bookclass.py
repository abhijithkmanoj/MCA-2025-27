#Create class Book (title, author). Add attribute 'publisher' at runtime. 
#If the attribute 'publisher' is available in Book object, then print <title> written by <author> is published by <publisher>, else print 'Unknown Publisher'

class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author

b1 = Book("The Tsunami", "Maxin Ottemberg")

b1.publisher = "Harper Books"

def print_book_info(book):
    if hasattr(book, 'publisher'):
        print(f"{book.title} written by {book.author} is published by {book.publisher}")
    else:
        print("Unknown Publisher")

print_book_info(b1)
#without publisher
b2 = Book("The Tornado", "Harry Rodriguez")
print_book_info(b2)