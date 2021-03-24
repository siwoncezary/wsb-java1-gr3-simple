package pl.wsb;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sideA;
        double sideB;
        System.out.println("Wpisz bok 1:");
        boolean isValidDouble = scanner.hasNextDouble();
        if(!isValidDouble){
            System.out.println("Wpisałeś daną niepasującą do liczby zmiennoprzecikowej!");
            System.out.println("Koniec programu");
            return;
        }
        sideA = scanner.nextDouble();
        System.out.println("Wpisz bok 2:");
        if (!scanner.hasNextDouble()){
            System.out.println("Wpisałeś daną niepasującą do liczby zmiennoprzecikowej!");
            System.out.println("Koniec programu");
            return;
        }
        sideB = scanner.nextDouble();
        boolean isValidSides = sideA >= 0 && sideB >=0;
        if (isValidSides){
            System.out.println("Pole: " + sideA * sideB);
            System.out.println("Obwód: " + (sideA + sideB) * 2);
        } else {
            System.out.println("Długości boków nie mogą być ujemne!");
        }
    }
}
