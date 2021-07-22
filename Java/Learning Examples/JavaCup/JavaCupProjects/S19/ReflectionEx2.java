package ir.blog.mahdidavoodi;

import java.lang.reflect.Field;

/*
 * Another example of Reflection.
 * We can swap Integer values, even they are final and private! 😬
 * In Object oriented opinion, this shit is annoying!
 * Because we made them private, but we can simply change them.
 * (I could not swap them, I think its because of the updates. But i could copy one to another.)
 * */
public class ReflectionEx2 {
    public static void main(String[] args) {
        Integer first = 3;
        Integer second = 10;
        System.out.println("Before copy: ---> First: " + first + " ---> Second: " + second);
        copy(first, second);
        System.out.println("After copy: ---> First: " + first + " ---> Second: " + second);
    }

    protected static void copy(Integer first, Integer second) {
        try {

            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            // Just like that. Now we can access to its value.
            field.set(second, first.intValue());
            field.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
