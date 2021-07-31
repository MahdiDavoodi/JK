package davoodi.mahdi.java;

import java.util.function.Function;

/*
 * This is an example for partial application*/
public class C4S2 {

    public static void main(String[] args) {
        Function<String, Function<String, String>> createSentence =
                (string) -> (s) -> s + string;
        Function<String, String> sayHelloToMe = createSentence.apply("Mahdi");
        System.out.println(sayHelloToMe.apply("Hello "));
    }
}
