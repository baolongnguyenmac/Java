package nblong;

import java.util.Scanner;

public class Exercise01 {
    static int input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        return n;
    }

    public static int calculate() {
        // input
        int n;
        do {
            System.out.print("Enter n: ");
            n = input();
        } while (!(3 < n && n < 50));

        // calculate
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }

        System.out.printf("Exercise01: n = %d, s = %d\n", n, s);

        return s;
    }
}