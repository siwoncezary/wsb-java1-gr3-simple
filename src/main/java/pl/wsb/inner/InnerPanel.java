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
    //interfejs wymuszania wywołania metody width w builderze
    interface RequireWidth{
        RequireHeight width(double val);
    }
    //interfejs wymuszania wywołania metody height w builderze, po tej metodzie można już ewentualnie
    //budować metodą build()
    interface RequireHeight{
        Builder height(double val);
    }

    //metoda zwraca buildera jako referencję do interfejsu, co powouje, że można wywołać tylko
    // metodę width
    public static RequireWidth builder(){
        return new Builder();
    }

    public static class Builder implements RequireWidth, RequireHeight{
        //pole obowiązkowe
        private double width;
        //pole obowiązkowe
        private double height;
        //pola opcjonalne
        private int unitPrice;
        private Border border;

        public Builder(){
        }

        public Builder width(double val){
            this.width = val;
            return this;
        }
        public Builder height(double val){
            this.height = val;
            return this;
        }

        public Builder unitPrice(int val){
            this.unitPrice = val;
            return this;
        }

        public Builder border(Border val){
            this.border = val;
            return this;
        }

        public InnerPanel build(){
            final InnerPanel panel = new InnerPanel(width, height, unitPrice);
            panel.border = this.border;
            return panel;

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
