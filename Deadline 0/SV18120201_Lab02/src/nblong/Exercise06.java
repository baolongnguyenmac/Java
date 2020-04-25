package nblong;

public class Exercise06 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n > 6));

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)1/(i * (i + 1));
        }

        System.out.println("Exercise 6: n = " + n + ", s = " + s);

        return s;
    }
}