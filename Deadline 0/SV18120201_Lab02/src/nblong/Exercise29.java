package nblong;

public class Exercise29 {
    private static int count = 0;
    private static int[] a = new int[1000];

    public static void back(int i, int n) {
        for (int j = 1; j <= 2; j++) {
            a[i] = j;
            int sum = 0;
            for (int f = 1; f <= i; f++) {
                sum += a[f];
            }
            if (sum == n) {
                for (int f = 1; f <= i; f++) {
                    System.out.printf("%d ", a[f]);
                }
                System.out.println();
                count++;
            }
            else if (i == n) {

            }
            else {
                back(i + 1, n);
            }
        }
    }

    public static void e29() {
        System.out.print("Enter the height of the hill: ");
        int n = Exercise01.input();
        back(1, n);
        System.out.println("There're " + count + " way(s) to get high");
    }
}