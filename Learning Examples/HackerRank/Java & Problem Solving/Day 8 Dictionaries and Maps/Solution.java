import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int phoneNumber = scanner.nextInt();
            phoneBook.put(name, phoneNumber);
        }

        // Now we going to read from input.

        while (scanner.hasNext()) {
            String string = scanner.next();
            if (phoneBook.containsKey(string)) {
                System.out.println(string + "=" + phoneBook.get(string));
            } else System.out.println("Not found");
        }
        scanner.close();
    }
}
