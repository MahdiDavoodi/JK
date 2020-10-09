package ir.blog.mahdidavoodi;

public class EquationSolver {
    // Solve a * x + b = 0
    public  static void SolveEq1 (double a,double b){
        double x = -b/a;
        System.out.format("Result is x = %f\n",x);
    }
}
