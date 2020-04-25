package nblong;

import java.util.ArrayList;

public class Exercise28 {
    public static ArrayList<Integer> handleCollision() {
        ArrayList<Integer> list = new ArrayList<Integer>(123);

        int temp;
        while (true) {
            System.out.print("Enter element of array (press -1 to stop): ");
            temp = Exercise01.input();
            if (temp == -1) {
                break;
            }
            list.add(temp);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Exercise 28");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        return list;
    }
}