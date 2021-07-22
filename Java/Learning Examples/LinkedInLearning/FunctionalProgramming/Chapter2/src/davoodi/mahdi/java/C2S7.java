package davoodi.mahdi.java;

/*This is an example for understanding closure.
 * It means if we return X function from Y function, X function still has access to Y function variables.
 * And this is what makes it useful. */
public class C2S7 {
    public static void main(String[] args) {
        // The return function will have access to my_name String in this function.
        MyNoArgFunction<MyNoArgFunction<String>> function =
                () -> () -> {
                    String my_name = "Mahdi";
                    return "Hey there! This is " + my_name;
                };
        MyNoArgFunction<String> greeting = function.apply();
        System.out.println(greeting.apply());
    }
}
