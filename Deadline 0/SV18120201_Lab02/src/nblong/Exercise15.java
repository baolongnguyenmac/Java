package nblong;

public class Exercise15 {
    static int cal(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        return s;
    } 

    public static double calculate() {
        // input
        int n = Exercise01.input();

        // cal
        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += (double)1/(cal(i));
        }

        System.out.println("Exercise 15: n = " + n + ", s = " + s);

        return s;
    }
}