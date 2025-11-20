#Create class Rectangle (length, breadth). Derive class Cuboid (height) from Rectangle. 
# Compare 2 Cuboid based on volume by overloading '<' operator.

class Rectangle:
    def __init__(self, length=0, breadth=0):
        self.length = length
        self.breadth = breadth

    def area(self):
        return self.length * self.breadth


class Cuboid(Rectangle):
    def __init__(self, length=0, breadth=0, height=0):
        super().__init__(length, breadth)
        self.height = height

    def volume(self):
        return self.area() * self.height

    def __lt__(self, other):
        if isinstance(other, Cuboid):
            return self.volume() < other.volume()
        return NotImplemented

print("Enter dimensions for Cuboid 1:")
l1 = int(input("Length: "))
b1 = int(input("Breadth: "))
h1 = int(input("Height: "))

print("\nEnter dimensions for Cuboid 2:")
l2 = int(input("Length: "))
b2 = int(input("Breadth: "))
h2 = int(input("Height: "))

c1 = Cuboid(l1, b1, h1)
c2 = Cuboid(l2, b2, h2)

print(f"\nVolume of Cuboid 1: {c1.volume()}")
print(f"Volume of Cuboid 2: {c2.volume()}")

if c1 < c2:
    print("Cuboid 1 is smaller than Cuboid 2")
else:
    print("Cuboid 1 is not smaller than Cuboid 2")
