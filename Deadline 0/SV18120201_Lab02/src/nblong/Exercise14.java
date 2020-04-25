package nblong;

public class Exercise14 {
    public static int calculate() {
        int n = Exercise01.input();
        int x = Exercise01.input();

        int s = 0;
        for (int i = 0; i <= n; i++) {
            s += Math.pow(x, 2 * i + 1);
        }

        System.out.printf("Exercise 12: n = %d, x = %d   s = %d\n", n, x, s);
        return s;
    }
}