package bai2;

import java.util.Scanner;

public class Bai2 {

    public static float input() {
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        return a;
    }

    public static void main(String[] args) {
        System.out.print("Nhap chieu dai: ");
        float dai = input();
        if (dai <= 0) {
            System.out.println("Du lieu dau vao khong hop le");
            System.exit(1);
        }
        System.out.print("Nhap chieu rong: ");
        float rong = input();
        if (rong <= 0) {
            System.out.println("Du lieu dau vao khong hop le");
            System.exit(1);
        }

        System.out.printf("Chu vi hinh chu nhat la: %f\n", 2 * (dai + rong));
        System.out.printf("Dien tich hinh chu nhat la: %f\n", dai * rong);
    }
}