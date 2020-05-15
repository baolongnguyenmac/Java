package nblong;

import java.util.ArrayList;

public class Exercise25 {
    public static void binarySearch() {
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

        System.out.println("Exercise 25");
        System.out.print("Enter value to find: ");
        int x = Exercise01.input();
        int result = search(x, 0, list.size() - 1, list);
        if (result == -1) {
            System.out.println("Can't find the entered value");
            System.out.println("inserted the entered value to list");
            list.add(findPos(x, 0, list.size() - 1, list), x);
            print(list);
        }
        else {
            System.out.println("Find one in the list: " + x);
        }
    }

    public static void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static int findPos(int x, int left, int right, ArrayList<Integer> list) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (x < list.get(mid)) {
                return findPos(x, left, mid - 1, list);
            }
            return findPos(x, mid + 1, right, list);
        }
        return left;
    }

    public static int search(int x, int left, int right, ArrayList<Integer> list) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (x == list.get(mid)) {
                return x;
            }
            if (x < list.get(mid)) {
                return search(x, left, mid - 1, list);
            }
            return search(x, mid + 1, right, list);
        }
        return -1;
    }
}