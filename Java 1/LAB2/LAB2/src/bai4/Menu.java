package bai4;

import java.util.Scanner;

public class Menu {
    private int _choice;

    private void printMenu() {
        // Runtime.getRuntime().exec("clear");
        System.out.println("1. Giai phuong trinh bac nhat");
        System.out.println("2. Giai phuong trinh bac hai");
        System.out.println("0. Thoat");
        System.out.print("> ");
    }

    public void executeMenu() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        _choice = scanner.nextInt();
        switch (_choice) {
            case 0: {
                System.exit(1);
            } break;

            case 1: {   // giai phuong trinh bac nhat
                System.out.println("giai phuong trinh bac nhat");
                GiaiBac1 b1 = new GiaiBac1();

                System.out.print("Nhap a: ");
                b1.setA(scanner.nextFloat());
                System.out.print("Nhap b: ");
                b1.setB(scanner.nextFloat());
                b1.solve();
            } break;

            case 2: {   // giai phuong trinh bac 2
                System.out.println("giai phuong trinh bac hai");
                GiaiBac2 b2 = new GiaiBac2();

                System.out.print("Nhap a: ");
                b2.setA(scanner.nextFloat());
                System.out.print("Nhap b: ");
                b2.setB(scanner.nextFloat());
                System.out.print("Nhap c: ");
                b2.setC(scanner.nextFloat());
                b2.solve();
            } break;

            default: {
                System.out.println("Sai du lieu dau vao");
                System.out.println("Nhap lai");
            } break;
        }
        scanner.close();
        executeMenu();
    }
}