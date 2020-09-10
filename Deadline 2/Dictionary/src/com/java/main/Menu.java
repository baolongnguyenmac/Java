package com.java.main;

import java.io.IOException;
import java.util.*;

import com.java.model.*;

public class Menu {
    private int inputInt(Scanner sc) {
        return sc.nextInt();
    }

    public void printTheFirstMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("1. Search Word in Anh_Viet dictionary");
        System.out.println("2. Search Word in Viet_Anh dictionary");
        System.out.println("3. Add new word to Anh_Viet dictionary");
        System.out.println("4. Add new word to Viet_Anh dictionary");
        System.out.println("5. Show History");
        System.out.println("6. Show Favorite");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    public void executeTheFirstMenu() {
        printTheFirstMenu();
        int choice = inputInt(new Scanner(System.in));

        switch (choice) {
            case 0: {
                Saver s = new Saver();
                s.save();
                System.exit(0);
            } break;

            case 1: {
                MyDictionary m = MyDictionary.getDictionary();
                m.searchWord(true); 
            } break;

            case 2: {
                MyDictionary m = MyDictionary.getDictionary();
                m.searchWord(false);
            } break;

            case 3: {
                MyDictionary m = MyDictionary.getDictionary();
                m.addWord(true);
            } break;

            case 4: {
                MyDictionary m = MyDictionary.getDictionary();
                m.addWord(false);
            } break;

            case 5: {
                History h = History.getHistory();
                h.statisticHistory();
            } break;

            case 6: {
                Favorite f = Favorite.getFavorite();
                System.out.print("Press 1 to print a-z/0 to print z-a: ");
                choice = inputInt(new Scanner(System.in));

                if (choice == 1) {
                    f.printList(true);
                }
                else {
                    f.printList(false);
                }
            } break;

            default: {
                System.out.println("Wrong choice");
            } break;
        }

        try {
            System.in.read();
        }
        catch (IOException e) {
            System.err.println(e);
        }
        executeTheFirstMenu();
    }
}