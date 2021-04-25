package pl.wsb.inner;

public class LocalClassDemo {
    public static void main(String[] args) {
        int val = 1000;
        class LocalClass{
            int a, b;
            int sum(){
                return a + b;
            }
            int diff(){
                return a - b;
            }

            int sumWithObj(LocalClass obj){
                return sum() + obj.sum();
            }

            int sumWithVal(){
                return val + sum();
            }
        }

        LocalClass pair = new LocalClass();
        pair.a = 5;
        pair.b = 6;
        System.out.println(pair.sumWithVal());

    }

    public static void helper(){
        //Tutaj nie można odwołąc się do klasy lokalnej
    }
}
