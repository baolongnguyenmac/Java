package nblong;

public class Exercise12 {
    public static int calculate() {
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int x = Exercise01.input();

        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += Math.pow(x, i);
        }

        System.out.printf("Exercise 12: n = %d, x = %d   s = %d\n", n, x, s);
        return s;
    }
}