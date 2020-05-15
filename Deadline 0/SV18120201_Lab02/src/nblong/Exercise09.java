package nblong;

public class Exercise09 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n > 6));

        // cal
        double s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }

        System.out.println("Exercise 9: n = " + n + ", s = " + s);

        return s;
    }
}