package java11;

import java.util.stream.Collectors;

public class Java11Example {

    public static void main(String[] args) {
        String s = " ";

        System.out.println(s.isBlank());
        System.out.println(s.isEmpty());

        String str = "Hi\nHello\nHow are you?";
        System.out.println(str);

        var list = str.lines()
                .collect(Collectors.toList());

        System.out.println(list);

        String str2 = "Hi";
        System.out.println(str2.repeat(5));

        char c = '\u2002';
        var str3 = c + " udemy " + c;
        System.out.println("::" + str3.strip() + "::");
        System.out.println("::" + str3.trim()+ "::");
        System.out.println("::" + str3.stripTrailing() + "::");
        System.out.println("::" + str3.stripLeading() + "::");


    }


}
