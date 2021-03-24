package pl.wsb.model;

import java.io.Serializable;
import java.util.Objects;

public class Panel extends Product implements Serializable {
    public static final long serialVersionUID = 1L;
    private double sideA;
    private double sideB;
    private int unitPrice;

    public Panel(double sideA, double sideB, int unitPrice, String name){
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.unitPrice = unitPrice;
    }

    public double area(){
        return sideB * sideA;
    }

    public double perimeter(){
        return (sideA + sideB) * 2;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public int price() {
        return (int) (area() * unitPrice);
    }

    @Override
    public String toString() {
        return "Panel, sideA : " + getSideA() +", sideB: " + getSideB() + ", name: " + getName();
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("PANEL EQUALS");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panel panel = (Panel) o;
        return Double.compare(panel.sideA, sideA) == 0 && Double.compare(panel.sideB, sideB) == 0 && unitPrice == panel.unitPrice;
    }

    @Override
    public int hashCode() {
        System.out.println("PANEL HASHCODE");
        return Objects.hash(sideA, sideB, unitPrice);
    }
}
