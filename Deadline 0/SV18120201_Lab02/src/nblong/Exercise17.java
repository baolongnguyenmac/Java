package nblong;

public class Exercise17 {

    public static double calculate() {
        System.out.println("Enter n: ");
        int n = Exercise01.input();
        // double s = cal(n);
        double s = Exercise11.cal(n);

        System.out.println("Exercise 17: n = " + n + ", s = " + s);

        return Exercise09.calculate();
    }
}