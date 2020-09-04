package java9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMethod {

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(4,2,1,4,5,3,1,2,4,6,7,7,9);

      /* Java 8 features
        System.out.println(
                numbers
                .filter(i -> i < 5)
                .collect(Collectors.toList())
        );
*/
     /*   // java 9 features
        System.out.println(
                numbers
                        .takeWhile(i -> i < 5)
                        .collect(Collectors.toList())
        );*/

       /* System.out.println(
                numbers.dropWhile(i -> i < 5)
                .collect(Collectors.toList())
        );*/

       //Before java 9 this is how we used to create list:

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);  // we could add null type as well, as list is of reference type integer so without having object it could be null.

        // We could also add list like this
        Collections.addAll(list, 1,2,3,4,5, null);

        // We could also add list like this
        Arrays.asList(1,2,3,4,5, null);

        //Java 9 approach to create list and does not allow add null.
        // if you want a list which should not be unmodifable. then this way of creating list is awesom.
        List<Integer> list1 = List.of(1, 2, 3, 4);

        System.out.println(
                list1
        );

        Set<String> set = Set.of("ab", "bc");
        System.out.println(set);

        System.out.println(
                set.stream()
                .filter(s -> s.contains("b"))
                .collect(Collectors.toSet())
        );
        // Set does not allow duplicate value.
        // List does allow duplicate value.
        System.out.println(
                Map.of(
                        "a", 10,
                        "b", 15,
                        "c", 21
                )
        );



    }
}
