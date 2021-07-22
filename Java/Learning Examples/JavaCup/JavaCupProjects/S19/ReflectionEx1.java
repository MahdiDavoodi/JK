package ir.blog.mahdidavoodi;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/*
 * A simple example for using Reflection options.
 * User can choose the class and method while the app running.
 * We have to input the class name like: ir.blog.mahdidavoodi.Hello
 * Also we can print annotations.
 * */
public class ReflectionEx1 {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine().trim();
        Class aClass = Class.forName(className);
        String methodName = scanner.nextLine().trim();
        Method method = aClass.getDeclaredMethod(methodName);
        Object o = aClass.newInstance();
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation :
                annotations) {
            System.out.println(annotation.annotationType());
        }
        method.invoke(o);
    }
}

@Deprecated
class Hello {
    protected void hello() {
        System.out.println("Hello World!");
    }
}

class Goodbye {
    protected void goodbye() {
        System.out.println("Goodbye World!");
    }
}
