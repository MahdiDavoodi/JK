package davoodi.mahdi.java;

/*
 * An example for recursion.
 * I tried but I could not implement this by Function interface.
 * Because you can't use recursion when you are defining the function!*/
public class C4S3 {

    public static int fac(int num) {
        if (num > 0)
            return num * fac(num - 1);
        else return 1;
    }

    public static void main(String[] args) {
        System.out.println(fac(5));
    }
}