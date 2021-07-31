package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {

        double[] array = {1, 2, 3, 4};

        System.out.format("----> n\t= %d\n", array.length);
        System.out.format("----> Sum\t= %f\n", ArraySum(array));
        System.out.format("----> Mean\t= %f\n", ArrayMean(array));
        System.out.format("----> Var.\t= %f\n", ArrayVar(array));
        System.out.format("----> St.D\t= %f\n", ArrayStd(array));

        System.out.print("----> Original Array: ");
        ShowArray(array);

        ModifyArray1(array);
        System.out.print("----> Modified Array 1: ");
        ShowArray(array);

        ModifyArray2(array);
        System.out.print("----> Modified Array 2: ");
        ShowArray(array);

        ModifyElement1(array[1]);
        System.out.print("----> Modify Element 1: ");
        ShowArray(array);

        ModifyElement2(array, 1);
        System.out.print("----> Modify Element 2: ");
        ShowArray(array);

    }

    public static double ArraySum(double[] A) {
        double sum = 0;
        for (double a : A) {                      // Foreach usage.
            sum += a;
        }
        return sum;
    }

    public static double ArrayMean(double[] A) {
        return ArraySum(A) / A.length;
    }

    public static double ArrayVar(double[] A) {
        double mean = ArrayMean(A);
        double variance = 0;
        for (double a : A) {
            variance += (a - mean) * (a - mean);
        }
        variance /= (A.length - 1);
        return variance;
    }

    public static double ArrayStd(double[] A) {
        return Math.sqrt(ArrayVar(A));
    }

    public static void ModifyArray1(double[] A) {
        for (double a : A) {
            a *= 2;
            // Foreach is not good for changing the array. because we have to work with index. We can add the index to this foreach tho.
        }
    }

    public static void ModifyArray2(double[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= 2;
        }
    }

    public static void ModifyElement1(double a) {
        // We have to work with index...
        a *= 2;
    }

    public static void ModifyElement2(double[] A, int i) {
        A[i] *= 2;
    }

    public static void ShowArray(double[] A) {
        for (double a : A) {
            System.out.format("%f ", a);
        }
        System.out.print("\n");
    }
}
