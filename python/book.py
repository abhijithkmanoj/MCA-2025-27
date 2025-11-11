#write a program that displays information about a python book . Use base class constructor invocation and method overriding
class Publisher:
    def __init__(self, name):
        self.name = name

    def display(self):
        print(f"Publisher: {self.name}")


class Book(Publisher):
    def __init__(self, name, title, author):
        super().__init__(name)  
        self.title = title
        self.author = author

    def display(self):
        super().display() 
        print(f"Title: {self.title}")
        print(f"Author: {self.author}")


class Python(Book):
    def __init__(self, name, title, author, price, no_of_pages):
        super().__init__(name, title, author)  
        self.price = price
        self.no_of_pages = no_of_pages

    
    def display(self):
        super().display() 
        print(f"Price: {self.price}")
        print(f"Number of Pages: {self.no_of_pages}")


p1 = Python("Idukki Geography", "Trees to climb for 3g network", "Ajaykumar", 25.99, 148)
p1.display()
p2 = Python("Deshabhimani", "101 mudravakyangal", "Adish Kannur", 45.99, 48)
p2.display()
    