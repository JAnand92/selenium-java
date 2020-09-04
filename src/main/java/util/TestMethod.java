package util;

public class TestMethod {

    public static void main(String[] args) {
        System.out.println(
                LinkUtil.getResponseCode("https://www.google.com/webhp?authuser=1")
        );
    }
}
