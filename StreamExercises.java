package com.epam.rd.at.java_stream_api.exercises;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercises {


    // task 1
    public static List<Integer> generateNumbers(int x) {
        return IntStream.range(1, x + 1).boxed().collect(Collectors.toList());
    }

    // task 2
    public static LocalDate findMostDistantDate(LocalDate anchorDate, LocalDate... datesToCompare) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(anchorDate);
        dates.addAll(List.of(datesToCompare));
        return dates.stream().max(Comparator.comparing(LocalDate::getDayOfYear)).get();
    }

    // task 3
    public static List<Integer> getOddElements(List<Integer> list) {
        return list.stream().filter(num -> num % 2 != 0).distinct().collect(Collectors.toList());
    }

    // task 4
    public static long countStringsWithUniqueCharacters(List<String> list) {

        return list.stream()
                .filter(item -> !item.isEmpty())
                .filter(item -> {
                    char[] chars = item.toCharArray();
                    Set<Character> uniqueCharacters = new HashSet<>();
                    for (char aChar : chars) {
                        uniqueCharacters.add(aChar);
                    }
                    return uniqueCharacters.size() == item.length();
                })
                .count();
    }

    // task 5
    public static List<String> sortByLengthDesc(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    // task 6
    public static boolean checkNoNegativeValues(List<Integer> list) {
        return !list.stream().filter(integer -> integer < 0).findAny().isPresent();
    }

    // task 7
    public static List<LocalDate> getRandomUniqueDates(int year, int limit) {
        LocalDate minDate = LocalDate.of(2020, 1, 1);
        return Stream.generate(() -> minDate.plusDays(ThreadLocalRandom.current().nextLong(365))).limit(10).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
    }

    // task 8
    public static <T> int indexOfByPredicate(List<Integer> list, Predicate<Integer> predicate) {
        int number = list.stream().filter(predicate).findFirst().orElse(-1);
        return list.indexOf(number);
    }

    // task 9
    public static Map<Month, Integer> generateMonthAndLengths() {
        return Arrays.stream(Month.values()).collect(Collectors.toMap(value -> value, value -> value.toString().length()));
    }

    // task 10
    public static char findMostFrequentChar(String string) {
        // Loop through String
        // Count the number of times each character repeats
        // return the character with the most count
//        string.chars().filter(string.

        String newString = string.replace(" ", "");

        ArrayList<Character> characters = new ArrayList<>();
        for (char c : newString.toCharArray()) {
            characters.add(c);
        }

        var ans = characters.stream()
                .map(ch -> {
                    long count = 0L;
                    for (char c : newString.toCharArray()) {
                        if (c==ch)
                            count++;
                    }
                    return new Pair<Character, Long>(ch, count) ;
                })
                .max((o1, o2) -> o1.right.compareTo(o2.right))
                .orElseThrow(() -> new RuntimeException("pir should not be null"))
                .left;

        return ans;


    }



    // task 11
    public static List<String> getValuesAndSort(List<Map<String, String>> list) {
       //extract variable = ctrl+alt+v
        //extract constant  ctrl + alt + c

        return list.stream() //Stream<Map<String,String>
               .map(Map::values)//stream of Collection<String>
                .flatMap(item -> item.stream()) //Stream of Strings
                .sorted((o1, o2) -> {

                    int compare = Integer.compare(o1.length(), o2.length());
                    if (compare == 0) {
                        compare = String.CASE_INSENSITIVE_ORDER.compare(o1,o2);
                    }
                    return compare;

                })
                .collect(Collectors.toList());

    }

}
class Pair<L, R> {
    L left;
    R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
}