package pl.wsb.model;

import java.io.Serializable;

public class BorderedPanel extends Panel implements Serializable {
    public static final long serialVersionUID = 1L;
    public static final int BORDER_UNIT_PRICE = 250;

    public BorderedPanel(double sideA, double sideB, int unitPrice, String name) {
        super(sideA, sideB, unitPrice, name);
    }

    public BorderedPanel(double sideA, double sideB, int price) {
        super(sideA, sideB, price, "Drewno");
    }

    @Override
    public int price() {
        return (int) (super.price() + perimeter() * BORDER_UNIT_PRICE);
    }

    @Override
    public String toString() {
        return "BorderedPanel{} " + super.toString();
    }
}
