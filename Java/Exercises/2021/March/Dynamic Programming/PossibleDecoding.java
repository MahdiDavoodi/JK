package ir.blog.mahdidavoodi;

/*
 * Some dynamic programming exercises for interviews.
 * I didn't solve this! I just understood and learned the answers!
 * */
class PossibleDecoding {

    static int countDecoding(char[] numbers, int numbersLength) {
        int[] table = new int[numbersLength + 1];
        table[0] = 1;
        table[1] = 1;
        if (numbers[0] == '0')
            return 0;
        for (int i = 2; i <= numbersLength; i++) {
            table[i] = 0;

            if (numbers[i - 1] > '0')
                table[i] = table[i - 1];

            if (numbers[i - 2] == '1' ||
                    (numbers[i - 2] == '2' &&
                            numbers[i - 1] < '7'))
                table[i] += table[i - 2];
        }
        return table[numbersLength];
    }

    public static void main(String[] args) {
        char[] numbers = {'1', '2', '3', '4'};
        System.out.println("---> Answer is: " + countDecoding(numbers, numbers.length));
    }
}
