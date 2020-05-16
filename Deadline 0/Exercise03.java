package nblong;

public class Exercise03 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n >= 7));

        // calculate
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)1/i;
        }

        System.out.println("Exercise 3: n = " + n + ", s = " + s);
        return s;
    }
}