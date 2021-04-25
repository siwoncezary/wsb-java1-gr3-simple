package pl.wsb.enums;
enum Color{
    RED, WHITE, BLACK, PLASTIC;
}
public class EnumEqualsDemo {
    public static final int RED = 1;
    public static final int WOOD = 1;
    public static void main(String[] args) {
        Color color = Color.PLASTIC;
        MaterialPanel panel = MaterialPanel.PLASTIC;
        //Porównanie stałych dwóch różnych typów nie jest możliwe
        //System.out.println(color == panel);

        System.out.println(color == Color.RED);
        System.out.println(color.equals(panel));
    }
}
