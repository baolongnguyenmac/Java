package bai1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ho va ten: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhap diem trung binh mon hoc: ");
        float diemTB = scanner.nextFloat();

        System.out.println("\n");

        System.out.println("Xin chao ban " + hoTen);
        System.out.println("Diem trung binh cua ban la: " + diemTB);

        System.out.println("\n");

        System.out.print("Xin chao ban " + hoTen + "\n");
        System.out.print("Diem trung binh cua ban la: " + diemTB + "\n");

        System.out.println("\n");

        System.out.printf("Xin chao ban %s\n", hoTen);
        System.out.printf("Diem trung binh cua ban la: %f\n", diemTB);
    }
}