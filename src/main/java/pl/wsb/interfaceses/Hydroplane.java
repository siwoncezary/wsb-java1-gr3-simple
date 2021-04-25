package pl.wsb.interfaceses;

public interface Hydroplane extends Flyable, Swimmingable{
    default void takeOffFromWater(){
        swim();
        takeOff();
    }
    static boolean isAbleToSwim(Object o){
        return o instanceof Swimmingable;
    }
}
