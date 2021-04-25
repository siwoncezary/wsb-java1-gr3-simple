package pl.wsb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Wpisz pierwszy bok:");
            int sideA = scanner.nextInt();
            System.out.println("Wpisz drugi bok:");
            int sideB = scanner.nextInt();
            System.out.println("Pole prostokąta: " + sideA * sideB);
            System.out.println("Obwód prostokąta: " + (sideA * 2 + sideB * 2));
        } catch (InputMismatchException exception){
            System.out.println("Wpisałeś niepoprawną liczbę, sprawdź czy nie ma tam innego znaku od cyfry.");
        }
    }
}
