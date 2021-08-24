/*
 * This class belongs to More04.kt.
 * */
public class JavaDeveloper {
    private final String name, language;
    private final int age;

    JavaDeveloper(String name, int age, String language) {
        this.name = name;
        this.age = age;
        this.language = language;
    }

    @Override
    public String toString() {
        return age +
                " years old " +
                name + ", codes with " +
                language + ".";
    }
}