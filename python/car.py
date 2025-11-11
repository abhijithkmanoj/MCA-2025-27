
class Engine:
    def __init__(self, power):
        self._power = power

    def display(self):
        print(f"Power: {self._power}")


class Wheels:
    def __init__(self, power, size):
        self._size = size

    def display(self):
        print(f"Wheel Size: {self._size}")


class Car(Engine,Wheels):
    def __init__(self, power, size, model):
        Engine.__init__(self,power)
        Wheels.__init__(self, size)
        
        self.__model = model


    def display(self):
        Engine.disp(self)
        Wheels.disp(self)
        print(f"Model: {self.__model}")


c1 = Car(350, 22, "Honda Esteem")
c1.display()


