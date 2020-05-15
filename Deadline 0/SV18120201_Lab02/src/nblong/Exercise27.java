package nblong;

import java.util.ArrayList;

public class Exercise27 {
    // search for elements that only appear once
    public static void solve() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int temp;
        while (true) {
            System.out.print("Enter element of array (press -1 to stop): ");
            temp = Exercise01.input();
            if (temp == -1) {
                break;
            }
            list.add(temp);
        }

        System.out.println("Exercise 27");
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j) && i != j) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(list.get(i));
            }
        }
    }
}