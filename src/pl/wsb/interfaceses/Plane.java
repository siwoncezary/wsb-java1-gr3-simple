package pl.wsb.interfaceses;

public class Plane implements Flyable{
    final String name;

    public Plane(String name) {
        this.name = name;
    }

    @Override
    public void takeOff() {
        System.out.println("Plane is taking off");
    }

    @Override
    public void land() {
        System.out.println("Plane is landing");
    }
}
