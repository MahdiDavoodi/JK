package ir.blog.mahdidavoodi;

public class Main {
        public static void main(String[] args) {

            int number;
            try {
                number = divide(10, 1);
                System.out.format("----> number = %d\n", number);
            }
            catch (ArithmeticException ex) {
                System.out.println("----> Something went wrong.");
                System.out.format("----> Exception : %s\n", ex);
            }
            finally {
                System.out.println("----> Finally Blocked!");
            }

        }

        public static int divide(int a, int b) {
            return a/b;
        }
}
