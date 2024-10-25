package example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream01 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("aaaa","bbba","c");
        Stream<String> stream = list.stream()
                .filter(li -> li.contains("a"));

        stream.forEach(System.out::println);
    }

}
