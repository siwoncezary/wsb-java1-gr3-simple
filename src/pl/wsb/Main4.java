package pl.wsb;

import pl.wsb.model.Panel;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Panel p1 = new Panel(3, 5, 1000, "DREWNO");
        Panel p2 = new Panel(3, 5, 1000, "DREWNO");
        p1 = null;

        if (Objects.equals(p1, p2)){
            System.out.println("Obiekty równe");
        } else {
            System.out.println("Obiekty różne");
        }
        Set<Panel> uniquePanels = new HashSet<>();
        uniquePanels.add(p2);
        uniquePanels.add(new Panel(6, 3, 2000,""));
        uniquePanels.add(new Panel(3, 6, 2000, ""));
        final boolean b = uniquePanels.add(new Panel(3, 5, 1000, "DREWNO"));
        System.out.println("Wynik add " + b);
        System.out.println(uniquePanels.size());

        Storage storePanel = new FileObjectStorage("c:\\data\\panels.ser");
        System.out.println("ZAPIS DO PLIKU");
        storePanel.save(new ArrayList<>(uniquePanels));
        System.out.println("ODCZYT PLIKU");
        final List<Panel> panelSet = storePanel.load();
        System.out.println("DANE ODCZYTANE Z PLIKU");
        for(Panel p: panelSet){
            System.out.println(p);
        }

    }
}
