package nblong;

public class Exercise08 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n > 6));

        // cal
        double s = 0;
        for (int i = 0; i <= n; i++) {
            s += (double)(2 * i + 1)/(2*i + 2);
        }

        System.out.println("Exercise 8: n = " + n + ", s = " + s);

        return s;
    }
}