package pl.wsb.enums;

import pl.wsb.model.Product;

public class Panel extends Product {
    double width;
    double height;
    MaterialPanel material;

    public Panel(double width, double height, MaterialPanel material) {
        super("");
        this.width = width;
        this.height = height;
        this.material = material;
    }

    public double area(){
        return width * height;
    }

    @Override
    public int price() {
//        switch (material){
//            case WOOD:
//                return (int) (area() * 500);
//            case COMPOSITE:
//                return (int) (area() * 400);
//            case PLASTIC:
//                return (int) (area() * 300);
//        }
        return (int) (area() * material.getUniPrice());
    }

    @Override
    public String toString() {
        return "Panel{" +
                "width=" + width +
                ", height=" + height +
                ", material=" + material +
                "} " + super.toString();
    }
}
