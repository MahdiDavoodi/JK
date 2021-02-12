/*
 * A simple factorial method with recursion.
 * */
public class FactorialRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(10));
        System.out.println(factorial(3));
    }

    protected static int factorial(int number) {
        if (number <= 0) return 1;
        else return number * factorial(number - 1);
    }
}
