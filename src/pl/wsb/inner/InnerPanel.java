package pl.wsb.inner;

public class InnerPanel {
    private double width;
    private double height;
    private int unitPrice;
    private Border border;

    public class Border{
        private double length;
        private int unitPrice;

        public Border(double length, int unitPrice) {
            this.length = length;
            this.unitPrice = unitPrice;
        }
    }

    public static class Builder{
        private double width;
        private double height;
        private int unitPrice;
        private Border border;
        public Builder(){
        }
    }

    public InnerPanel(double width, double height, int unitPrice) {
        this.width = width;
        this.height = height;
        this.unitPrice = unitPrice;
        this.border = new Border(2*width + 2* height, 1000);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public double getBorderLength(){
        return border.length;
    }
}
