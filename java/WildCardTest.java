import java.util.ArrayList;

abstract class Animal {
    abstract public void eat ();
}

class Cat extends Animal {
    @Override
    public void eat () {
        System.out.println ("I eat cat food!");
    }
}

class Dog extends Animal {
    @Override
    public void eat () {
        System.out.println ("I eat dog food!");
    }
}

public class WildCardTest {
    public void display(ArrayList<? extends Animal> list) {
        for (Animal animal : list) {
            animal.eat ();
        }
    }

    public static void main (String[] args) {
        ArrayList<Animal> aList = new ArrayList<> ();
        aList.add (new Cat ());
        aList.add (new Dog ());

        new WildCardTest ().display (aList);
    }
}