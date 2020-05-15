package bai4;

import java.util.ArrayList;

public class GiaiBac2 {

    public GiaiBac2() {
        a = b = c = 0;
    }

    public GiaiBac2(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Float> solve() {
        ArrayList<Float> nghiemPhuongTrinh = new ArrayList<Float>(2);

        if (a != 0) {
            float delta = (float)Math.pow(b, 2) - 4 * a * c;
            if (delta < 0) {
                nghiemPhuongTrinh.add(null);
                nghiemPhuongTrinh.add(null);
                System.out.println("Phuong trinh vo nghiem");
            }
            else if (delta >= 0) {
                nghiemPhuongTrinh.add((-b + (float)Math.sqrt(delta)) / (2 * a));
                nghiemPhuongTrinh.add((-b - (float)Math.sqrt(delta)) / (2 * a));
                if (delta > 0) {
                    System.out.printf("Phuong trinh co 2 nghiem phan biet: x1 = %f, x2 = %f\n", nghiemPhuongTrinh.get(0), nghiemPhuongTrinh.get(1));
                }
                else {
                    System.out.println("Phuong trinh co nghiem kep: x1 = x2 = " + nghiemPhuongTrinh.get(0));
                }
            }
        }
        else {
            System.out.println("Phuong trinh khong phai bac 2");
        }

        return nghiemPhuongTrinh;
    }


    private float a, b, c;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
}