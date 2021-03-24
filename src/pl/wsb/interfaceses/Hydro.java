package pl.wsb.interfaceses;

public class Hydro implements Hydroplane{
    @Override
    public void takeOff() {
        System.out.println("Hydro is taking off");
    }

    @Override
    public void land() {
        System.out.println("Hydro is landing");
    }

    @Override
    public void swim() {
        System.out.println("Hydro is swimming");
    }
}
