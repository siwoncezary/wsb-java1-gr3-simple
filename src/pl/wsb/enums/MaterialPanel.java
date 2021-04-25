package pl.wsb.enums;

public enum MaterialPanel {
    //public static final MaterialPanel WOOD = new MaterialPanel();
    WOOD(500), PLASTIC(300), COMPOSITE(400);
    private int uniPrice;
    MaterialPanel(int uniPrice){
        this.uniPrice = uniPrice;
    }

    public int getUniPrice() {
        return uniPrice;
    }
}
