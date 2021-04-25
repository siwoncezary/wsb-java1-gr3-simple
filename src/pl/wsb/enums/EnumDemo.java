package pl.wsb.enums;

import java.util.Scanner;

public class EnumDemo {
    public static void main(String[] args) {
        Panel panel = new Panel(3, 5, MaterialPanel.COMPOSITE);
        System.out.println(panel.price());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz nazwę materiału: Wybierz jedną z poniższych");
        for(MaterialPanel item: MaterialPanel.values()){
            System.out.println(item);
        }
        try {
            final MaterialPanel materialPanel = MaterialPanel.valueOf(scanner.next());
            System.out.println("Wybrałeś materiał " + materialPanel.name() +", który jest po numerem " + materialPanel.ordinal());
            System.out.println("Wpisz długość i wysokość panelu");
            double width = scanner.nextDouble();
            double height = scanner.nextDouble();
            panel = new Panel(width, height, materialPanel);
            System.out.println(panel);

        } catch (IllegalArgumentException e){
            System.out.println("Nie ma takiego materiału!");
        }
    }
}
