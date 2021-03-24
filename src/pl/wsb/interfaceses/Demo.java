package pl.wsb.interfaceses;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Flyable> list = new ArrayList<>();
        list.add(new Plane("Concorde"));
        list.add(new Duck());
        list.add(new Hydro());
        for(Flyable item: list){
            item.takeOff();
            item.land();
            System.out.println(Hydroplane.isAbleToSwim(item) ? "PLYWAJACY" : "NIE" );
        }
    }
}
