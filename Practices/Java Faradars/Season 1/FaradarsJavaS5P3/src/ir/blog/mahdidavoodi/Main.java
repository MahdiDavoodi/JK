package ir.blog.mahdidavoodi;

public class Main {

    public static void main(String[] args) {
        String s = "Hello World!";                // This is an object from String class.
        System.out.format("----> String is = %s\n",s);
        System.out.format("----> String length is = %d\n",s.length());       // String length
        System.out.format("----> IsEmpty = %s\n",s.isEmpty());               // Is String empty? return boolean but we can show it as String.
        System.out.format("----> Character at position 3 is = %s\n",s.charAt(3));    // Character at index 3.
        System.out.format("----> To lower case = %s\n",s.toLowerCase());
        System.out.format("----> To upper case = %s\n",s.toUpperCase());               // To lower case and upper case.
        System.out.format("----> First index of space = %d\n",s.indexOf(" "));          // First index of space.
        System.out.format("----> Ends with ! = %s\n",s.endsWith("!"));
        System.out.format("----> Starts with S ! = %s\n",s.startsWith("!"));          // Check the end and the start char and return true or false.
    }
}
