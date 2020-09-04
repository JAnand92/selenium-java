package assignment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstNameAssignment {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("resources/first-name.txt");
        List<String> list =  Files.readAllLines(path);


        // Print the count of name, starting with B

        System.out.println(
                list.stream()
                .filter(name -> name.startsWith("B"))
                .count()
        );
        //Create the list of names which starts with C and contains 's' in it

        List<String> names = list.stream()
                .filter(name -> name.startsWith("C"))
                .filter(name -> name.toLowerCase().contains("s"))
                .collect(Collectors.toList());
        System.out.println(names.size());

        //Print the total number of chars for all the name, starting  with M

        System.out.println(
                list.stream()
                        .filter(name -> name.startsWith("M"))
                        .map(name -> name.trim())
                        .map(name -> name.length())
                        .mapToInt(i -> i)
                        .sum()
        );

        // Find the name, containing - in it and replace it with a space; collect them into a list

        System.out.println(
                list.stream()
                .filter(name -> name.contains("-"))
                .map(name -> name.replaceAll("-", " "))
                .collect(Collectors.toList())
        );

        // Find the name which has more number of chars
        System.out.println(
                list.stream()
                .max(Comparator.comparing( s -> s.length()))
                .get()
        );
    }
}
