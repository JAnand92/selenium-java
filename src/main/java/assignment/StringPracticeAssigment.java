package assignment;

public class StringPracticeAssigment {
    public static void main(String[] args) {

        // counts the occurrence of a certain character in a given String.

        String str = "aaaabbbbbccccddddeeeeffffggiijjjkkk";

        System.out.println(
                str.chars()
                .filter(c -> c == 'a')
                .count()
        );

        String str1 = "php";
        String str2 = null;

        for (int i = 0; i < 7; i++) {
            str2 = str2.concat(str1);
        }
        System.out.println(str2);

    }
}
