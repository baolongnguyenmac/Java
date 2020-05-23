package com.java.main;

public class Menu {
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

    public void printMenuSearchWordAnh_Viet() {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter your word here: ");
    }

    public void printMenuSearchWordViet_Anh() {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter your word here: ");
    }

    public void printMenuAddWord() {
        
    }
}