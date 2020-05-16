package main;

public class Main {
    public static void main(String[] args) throws Exception {
        Product sp1 = new Product();
        Product sp2 = new Product();

        sp1.input();
        System.out.println("==============");
        sp2.input();
        System.out.println("==============");
        System.out.println("Information about product you've typed: \n");
        sp1.showProduct();
        System.out.println("==============");
        sp2.showProduct();
    }
}