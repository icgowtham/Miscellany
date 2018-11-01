class Parent {
    public Parent overload() {
        System.out.println ("Creating and returning a new Parent class object");
        return new Parent ();
    }
}

class Child extends Parent {
    @Override
    public Child overload() {
        System.out.println ("Creating and returning a new Child class object");
        return new Child ();
    }
}

public class TstOverride {
    public static void main (String[] args) {
        Parent p = new Child ();
        p.overload ();
    }
}