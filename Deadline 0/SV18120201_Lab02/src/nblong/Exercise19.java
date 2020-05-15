package nblong;

public class Exercise19 {
    public static double calculate() {
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int x = Exercise01.input();

        double s = 1;
        for (int i = 1; i <= n; i++) {
            s += x * 2 * i / Exercise11.cal(2 * i);
        }

        System.out.println("Exercise 19: n = " + n + ", s = " + s);
        return s;
    }
}