package nblong;

public class Exercise10 {
    public static double calculate() {
        // input
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int x = Exercise01.input();

        System.out.println("Exercise 10: x = " + x + " n = " + n + "   " + Math.pow(x, n));

        return Math.pow(x, n);
    }
}