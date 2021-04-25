package pl.wsb.inner;

@FunctionalInterface
interface Bonus{
    int calc(int totalPrice);
}

interface Function{
    double calc(double a, double b);
}

public class FunctionsDemo {
    private static int customerAge = 8;
    public static void main(String[] args) {

        //Function add = (a, b) -> Double.sum(a, b);

        //Referencja do metody
        Function add = Double::sum;
        Bonus overHundred = new Bonus() {
            @Override
            public int calc(int t) {
                return t > 100 ? 2 : 0;
            }
        };
        Bonus overHundredLambda = t -> t > 100 ? 2 : 0;

        final int age = 6;
        Bonus ageBonus = new Bonus(){
            private int age = 5;
            @Override
            public int calc(int totalPrice) {
                return this.age >= 5 ? 5 : 0;
            }
        };

        Bonus ageBonusLambda = price -> {
          if (age >= 5){
              return 5;
          } else {
              return 0;
          }
        };
        System.out.println(overHundred.calc(112));
        System.out.println(ageBonus.calc(154));
        System.out.println(overHundred.calc(200) + ageBonus.calc(200));

    }
}
