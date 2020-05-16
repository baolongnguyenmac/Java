package nblong;

public class Exercise21 {
    public static void calculate() {
        System.out.println("Enter n ");
        int n = Exercise01.input();
        System.out.println("Enter x ");
        int m = Exercise01.input();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Exercise01.input();
            }
        }

        int min = 10000, max = -1000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                }
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }

        System.out.println("max = " + max + ", min = " + min);

        System.out.println("Enter value you wanna find: ");
        int x = Exercise01.input();
        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == x) {
                    isFound = true;
                    System.out.printf("pos: (%d, &d)\n", i, j);
                }
            }
        }
        if (!isFound) {
            System.out.println("(-1, -1)");
        }
    }
}