package java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FileReadingAndWritingTest {

    public static void main(String[] args) throws Exception{
        Path path = Paths.get("resources/java-11.txt");
        Files.writeString(path, "Java Java Java Java is is is cool");

        System.out.println(
                Files.readString(path)
        );
        var str = Files.readString(path);
        System.out.println(
                str.chars().filter(i -> i == 'a').count()
        );

        var newStr = str.split(" ");
        System.out.println(
                Arrays.stream(newStr)
                        .map(s -> s.strip())
                        .count()
        );

        /*Read a file and count the number of words in it*/
        Path p = Paths.get("resources/java-11.txt");
        var s = Files.readString(p).split(" ");
        System.out.println(s.length);
        var items = new HashSet<>();
        System.out.println("Number of duplicate words " +
                Arrays.stream(s).filter(s1 -> !items.add(s1))
                .collect(Collectors.toSet()).size()
        );
    }

}
