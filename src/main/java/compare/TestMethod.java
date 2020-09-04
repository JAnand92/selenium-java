package compare;

import java.util.*;
import java.util.stream.Stream;

public class TestMethod {

    public static void main(String[] args) {
        Student a = new Student("Adam", 80, 150);
        Student b = new Student("Bdam", 90, 130);
        Student c = new Student("Cdam", 60, 120);


        Optional<Student> op = Stream.of(a, b, c)
                .min(Comparator.comparing(s -> s.getScore()));

        System.out.println(op.get());


        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9);

        System.out.println(
                list.stream()
                        .mapToInt(j -> j)
                        .sum()
        );
    }
}
