package nblong;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise30 {
    public static void findTheLongestString() {
        ArrayList<String> listStr = new ArrayList<String>();
        String str = new String();
        Scanner sc = new Scanner(System.in);

        int max = -100000;

        System.out.print("Enter the number of words: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your string: ");
            str = sc.next();
            listStr.add(str);
            if (max < str.length()) {
                max = str.length();
            }
        }
        sc.close();

        for (int i = 0; i < listStr.size(); i++) {
            if (listStr.get(i).length() == max) {
                System.out.println(listStr.get(i));
            }
        }
    }
}