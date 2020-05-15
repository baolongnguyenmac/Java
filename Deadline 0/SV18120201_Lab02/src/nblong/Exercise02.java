package nblong;

public class Exercise02 {
    public static int calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = Exercise01.input();
        } while (!(5 <= n && n <= 20));

        // calculate
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += Math.pow(i, 2);
        }

        System.out.println("Exercise 02: n = " + n + ", s = " + s);
        return s;
    }
}