package nblong;

public class Exercise11 {
    static double cal(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        return s;
    }

    public static double calculate() {
        // input
        System.out.println("Enter n: ");
        int n = Exercise01.input();

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += cal(i);
        }

        System.out.println("Exercise 11: n = " + n + ", s = " + s);

        return s;
    }
}