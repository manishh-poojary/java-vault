package com.toolkit.java.vault.core_concepts.java8features.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;

public class Example {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "HR", 50000),
                new Employee(2, "Jane", "IT", 70000),
                new Employee(3, "Mike", "IT", 80000),
                new Employee(4, "Sara", "Finance", 60000),
                new Employee(5, "Paul", "HR", 55000)
        );

        Map<String, Optional<Employee>> salary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(salary);

        Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(result);

        List<Map.Entry<String, Long>> values = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).toList();

        values.forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());

        });

        Optional<?> vals = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary))).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        System.out.println(vals);

        String b = "banana";

        Optional<Map.Entry<Character, Long>> maxCharacter = b.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(comparingByValue());
        System.out.println(maxCharacter);

        Optional<Map.Entry<Character, Long>> firstUniqueCharacter = b.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).findFirst();

        System.out.println(firstUniqueCharacter);

        Optional<Map.Entry<Character, Long>> maxName = employees.stream().map(e -> e.getName().charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(comparingByValue());
        System.out.println(maxName);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int window = 4;

        List<Double> res = IntStream.range(0, (list.size() - (window - 1)))
                .mapToObj(i -> list.subList(0, i + window))
                .map(val -> val.stream().mapToInt(Integer::intValue).average().orElse(0.0)).toList();
        System.out.println(res);

        String sentence = "The quick, brown fox jumped over the lazy dog!";

        String maxLength = Arrays.stream(sentence.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" "))
                .max(Comparator.comparing(String::length)).orElse("");
        System.out.println(maxLength);


        String paragraph = "Java is great great is. Java is object oriented. Java streams are powerful, and Java is fun!";

        Map<String, Long> map = Arrays.stream(paragraph.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sorted = map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).toList();

        List<Long> topFrequency = sorted.stream().map(Map.Entry::getValue).distinct().limit(3).toList();
        List<Map.Entry<String, Long>> resul = sorted.stream()
                .filter(e -> topFrequency.contains(e.getValue()))
                .toList();
        System.out.println(resul);


        String merged = Arrays.stream(sentence.split(" "))
                .map(word -> Arrays.stream(word.split("")).reduce("", (rev, ch) -> ch + rev))
                .collect(Collectors.joining(" "));
        System.out.println(merged);

    }
}


