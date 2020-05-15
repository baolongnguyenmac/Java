package nblong;

import java.util.ArrayList;

public class Exercise26 {
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

        if (list.size() % 2 == 0) {
            System.out.println("Exercise 26: " + list.get(list.size()/2) + " " + list.get(list.size()/2 + 1));
        }
        else {
            System.out.println("Exercise 26: " + list.get(list.size() / 2));
        }
    }
}