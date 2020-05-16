package bai4;

public class GiaiBac1 {

    public Float solve() {
        Float x = null;

        if (a != 0) {
            x = -b / a;
            System.out.println("Nghiem duy nhat: x = " + x);
        }
        else {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem");
            }
            else {
                System.out.println("Phuong trinh vo nghiem");
            }
        }

        return x;
    }

    private float a, b;

    public GiaiBac1() {
        a = b = 0;
    }

    public GiaiBac1(float a, float b) {
        this.a = a;
        this.b = b;
    }

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
}