package google.test;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperationTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");

        System.out.println(
                list.stream()
                .count()
        );

        System.out.println(
                list.stream()
                .filter(s -> s.length() > 3)
                .count()
        );

        System.out.println(
                list.stream()
                .filter(s -> s.length() > 3)
                .findFirst()
        );

        Optional<String> op = list.stream()
                .filter(s -> s.length() > 3)
                .findFirst();

        if(op.isPresent()) {
            System.out.println(
                    op.get()
            );
        }

        System.out.println(
                list.stream()
                .max(Comparator.naturalOrder())
                .get()
        );

        System.out.println(
                list.stream()
                .max(Comparator.reverseOrder())
                .get()
        );

        System.out.println(
                list.stream()
                .filter(s -> s.length() > 3)
                .anyMatch(s -> s.contains("e"))
        );

        /*Collector - List example*/
        List<String> newList = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());

        System.out.println("Original :: " + list);
        System.out.println("New List :: " + newList);

        /*Collector  - Set example*/
        Set<String> newSet = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toSet());
        System.out.println("Original :: " + list);
        System.out.println("New Set :: " + newSet);

        /*Collector - Joining example*/

        String joinedString = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining(";"));

        System.out.println(joinedString);

        /*Group by - example*/

        Map<Integer, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s.length()));

        Map<Object, List<String>> charAt = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(charAt);

    }
}
