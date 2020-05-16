package nblong;

public class Exercise05 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n >= 2));

        // cal
        double s = 0;
        for (int i = 0; i <= n; i++) {
            s += (double)1/(2 *i + 1);
        }

        System.out.println("Exercise 5: n = " + n + ", s = " + s);

        return s;
    }
}