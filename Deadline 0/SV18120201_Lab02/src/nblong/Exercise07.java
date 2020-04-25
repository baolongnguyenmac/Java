package nblong;

public class Exercise07 {
    public static double calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(n >= 1));

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)i/(i + 1);
        }

        System.out.println("Exercise 7: n = " + n + ", s = " + s);

        return s;
    }
}