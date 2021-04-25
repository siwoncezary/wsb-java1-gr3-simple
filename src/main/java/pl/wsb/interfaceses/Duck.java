package pl.wsb.interfaceses;

public class Duck implements Flyable, Swimmingable{
    @Override
    public void takeOff() {
        System.out.println("Duck is taking off");
    }

    @Override
    public void land() {
        System.out.println("Plain is landing");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}
