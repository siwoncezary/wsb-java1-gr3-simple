package pl.wsb;

import pl.wsb.model.Panel;
import pl.wsb.model.Product;
import pl.wsb.model.BorderedPanel;

public class Main3 {
    public static void main(String[] args) {
        Panel panel = new BorderedPanel(1, 1, 10_000);
        System.out.println(panel.area());
        Product[] panels = new Panel[5];
        panels[0] = panel;
        panels[1] = new Panel(5, 1, 24, "Laminat");
        panels[2] = new Panel(4, 2, 25, "Drewno");
        panels[3] = new Panel(3.4, 1.4, 12, "PCV");
        for(int i = 0; i < panels.length; ++i){
            if(panels[i] == null){
                continue;
            }
            if (panels[i] != null) {
                System.out.println("Cena: " + panels[i].price());
            }
        }
        System.out.println("koniec for!");
        for(Product p: panels){
            if (p == null){
                continue;
            }
            if (p instanceof BorderedPanel){
               BorderedPanel product = (BorderedPanel) p;
                System.out.println("Cena " + product.price());
            }
            System.out.println("Produkt: " + p.getName() +" cena: " + p.price());
            System.out.println(p);
        }
        System.out.println("Koniec foreach!");

    }
}
