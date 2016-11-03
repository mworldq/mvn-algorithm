package com.caocao.baseOP;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by m on 16-11-1.
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("BB", "CC", "AA");
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        System.out.println(names);

        //way 1
//        List<String> lowercaseNames = names.stream().map((String name) -> {
//            return name.toLowerCase();
//        }).collect(Collectors.toList());

        //way2
//        List<String> lowercaseNames = names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());

        //way3
        List<String> lowercaseNames = names.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowercaseNames);

        names.stream().map(name -> name.charAt(0)).collect(Collectors.toList());
        System.out.println(names);

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.of(new int[]{4, 5, 6}).forEach(a -> System.out.println(a));
        System.out.println(IntStream.of(new int[]{4, 5, 6}).reduce(0, (a, b) -> a + b));

        List<Integer> list = Arrays.asList(1, 2, 3);
        list = list.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(list);

        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);
        Stream a = Stream.generate(random);
        System.out.println(a.collect(Collectors.toSet()));
    }
}
