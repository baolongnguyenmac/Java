package nblong;

public class Exercise18 {
    public static double calculate() {
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int x = Exercise01.input();

        double s = 0;
        for (int i = 1; i <= n; i++) {
            s += x * i / Exercise11.cal(i);
        }

        System.out.println("Exercise 18: n = " + n + ", s = " + s);
        return s;
    }
}