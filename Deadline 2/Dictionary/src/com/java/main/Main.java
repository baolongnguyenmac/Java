package com.java.main;

public class Main {
    public static void main(String[] args) {
        Loader l = new Loader();
        l.load();

        Menu m = new Menu();
        m.executeTheFirstMenu();
    }
}