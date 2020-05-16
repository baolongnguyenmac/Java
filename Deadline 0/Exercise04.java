package nblong;

public class Exercise04 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n > 9));

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)1/(2 *i);
        }

        System.out.println("Exercise 4: n = " + n + ", s = " + s);

        return s;
    }
}