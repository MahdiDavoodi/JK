/*
 * An example of using Kotlin from Java.
 * */
public class More05 {
    public static void main(String[] args) {
        // Using our Kotlin class here.
        KotlinDeveloper developer = new KotlinDeveloper("Mahdi",
                18,
                "Kotlin / Java");
        developer.setAge(25);
        developer.setName("Nathan");
        developer.setLanguage("C++");

        System.out.println(developer);

        // Using our generic Kotlin function here.
        System.out.println("---> Is 12 == 23? "
                + More03Kt.isEqual(12, 23));
    }
}