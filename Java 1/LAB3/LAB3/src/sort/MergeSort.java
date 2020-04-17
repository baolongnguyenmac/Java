package sort;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    public static ArrayList<Integer> inputArray() {
        ArrayList<Integer> list = new ArrayList<Integer>(5);
        System.out.print("Nhap so phan tu: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap phan tu thu %d: ", i);
            list.add(sc.nextInt());
        }

        sc.close();
        return list;
    }

    public static void printArray(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println();
    }

    public static void mergeSort(ArrayList<Integer> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    public static void mergeSort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, right, mid);
        }
    }

    public static void merge(ArrayList<Integer> list, int left, int right, int mid) {
        int i = left, j = mid + 1, k = 0;
        int[] helper = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (list.get(i) < list.get(j)) {
                helper[k] = list.get(i);
                i++;
            }
            else {
                helper[k] = list.get(j);
                j++;
            }
            k++;
        }

        while (i <= mid) {
            helper[k] = list.get(i);
            i++;
            k++;
        }
        while (j <= right) {
            helper[k] = list.get(j);
            k++;
            j++;
        }

        i = left;
        for (int x = 0; x < right - left + 1; x++) {
            list.set(i, helper[x]);
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = inputArray();
        mergeSort(list);
        printArray(list);
    }
}