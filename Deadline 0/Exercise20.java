package nblong;

public class Exercise20 {
    public static double calculate() {
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int x = Exercise01.input();

        double s = 1 + x;
        for (int i = 1; i <= n; i++) {
            s += (x * (2 * i + 1))/ Exercise11.cal(1 + 2 * i);
        }

        System.out.println("Exercise 20: n = " + n + ", s = " + s);
        return s;
    }
}  