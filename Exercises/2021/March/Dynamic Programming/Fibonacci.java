package ir.blog.mahdidavoodi;

public class Fibonacci {

    static long stepCounter1 = 0, stepCounter2 = 0;

    public static void main(String[] args) {
        System.out.println("$ The 14th number of Fibonacci Sequence is (Normal): " + normalFibonacci(14));
        System.out.println("---> Step numbers: " + stepCounter1);
        System.out.println("$ The 14th number of Fibonacci Sequence is (Dynamic): " + dynamicFibonacci(14));
        System.out.println("---> Step numbers: " + stepCounter2);

    }

    private static long normalFibonacci(int n) {
        if (n >= 2) {
            stepCounter1++;
            return normalFibonacci(n - 1) + normalFibonacci(n - 2);
        } else if (n == 1) return 1;
        else return 0;
    }

    private static long dynamicFibonacci(int n) {
        Long[] data = new Long[n + 2];
        data[0] = 0L;
        data[1] = 1L;
        return dynamicFibonacci(data, n);
    }

    private static long dynamicFibonacci(Long[] data, int n) {
        if (data[n] != null) {
            return data[n];
        } else {
            stepCounter2++;
            long answer = dynamicFibonacci(data, n - 1) + dynamicFibonacci(data, n - 2);
            data[n] = answer;
            return answer;
        }
    }
}