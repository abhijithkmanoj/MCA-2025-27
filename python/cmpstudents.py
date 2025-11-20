#Compare above 2 students based on pass percentage.

class Person:
    def __init__(self, name, roll):
        self.name = name
        self.roll = roll


class Marks:
    def __init__(self, maths, computer):
        self.maths = maths
        self.computer = computer


class Student(Person, Marks):
    def __init__(self, name, roll, maths, computer):
        Person.__init__(self, name, roll)
        Marks.__init__(self, maths, computer)

    def get_percentage(self):
        return (self.maths + self.computer) / 2

    def display(self):
        percentage = self.get_percentage()
        print(f"\nName     : {self.name}")
        print(f"Roll No    : {self.roll}")
        print(f"Maths      : {self.maths}")
        print(f"Computer   : {self.computer}")
        print(f"Percentage : {percentage}%")
        
        if percentage >= 50:
            print("Result     : PASS")
        else:
            print("Result     : FAIL")



s1 = Student("Rahul", 1, 45, 70)
s2 = Student("Anita", 2, 80, 55)

s1.display()
s2.display()

p1 = s1.get_percentage()
p2 = s2.get_percentage()

print("\nResult:")

if p1 > p2:
    print(f"{s1.name} has a higher percentage ({p1}%) than {s2.name} ({p2}%).")
elif p2 > p1:
    print(f"{s2.name} has a higher percentage ({p2}%) than {s1.name} ({p1}%).")
else:
    print(f"Both {s1.name} and {s2.name} have the SAME percentage ({p1}%).")
