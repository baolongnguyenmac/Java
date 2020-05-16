package main;

import java.util.Scanner;

public class Product {

    public void showProduct() {
        System.out.println("Product name: " + this._productName);
        System.out.println("Unit price: " + this._unitPrice);
        System.out.println("Discount: " + this._discount);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name: ");
        this._productName = sc.nextLine();
        System.out.print("Enter unit price: ");
        this._unitPrice = sc.nextDouble();
        System.out.print("Enter discount: ");
        this._discount = sc.nextDouble();
        // sc.close();
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public double get_unitPrice() {
        return _unitPrice;
    }

    public void set_unitPrice(double _unitPrice) {
        this._unitPrice = _unitPrice;
    }

    public double get_discount() {
        return _discount;
    }

    public void set_discount(double _discount) {
        this._discount = _discount;
    }

    public Product(String productName, double unitPrice, double discount) {
        this._productName = productName;
        this._unitPrice = unitPrice;
        this._discount = discount;
    }

    public Product(String productName, double unitPrice) {
        this(productName, unitPrice, 0);
    }

    public Product(){}

    private String _productName;
    private double _unitPrice;
    private double _discount;
}