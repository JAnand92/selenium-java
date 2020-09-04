package java10;

import baseTest.DriverFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java10Example {

    public static void main(String[] args) {

        var list = List.of(1,2,3);
        list.stream().filter(i -> i == i % 2).collect(Collectors.toUnmodifiableList());
    }

    private static void test() {
        var num = 10;
        var list = List.of(1,2,3,4,5);
        var map = Map.of("name1", 12, "name2", 13);

        var a = DriverFactory.getDriver("chrome");

        var var = 10;

        Consumer<Integer> doubleIt = (i) -> System.out.println(i+i);
        doubleIt.accept(10);
    }
}
