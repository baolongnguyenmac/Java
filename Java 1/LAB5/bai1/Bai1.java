package bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai1 {

    public static ArrayList<Double> input() {
        ArrayList<Double> list = new ArrayList<Double>();
        double temp;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number (press -1 to stop): ");
            temp = sc.nextDouble();
            if (temp == -1) {
                break;
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Double> list = Bai1.input();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println();
    }
}