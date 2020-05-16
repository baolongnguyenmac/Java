package nblong;

public class Exercise16 {

    public static double calculate() {
        // input
        int n = Exercise01.input();
        int x = Exercise01.input();

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)(i * x)/(Exercise15.cal(i));
        }

        System.out.println("Exercise 16: n = " + n + ", x = " + x + ", s = " + s);

        return s;
    }
}