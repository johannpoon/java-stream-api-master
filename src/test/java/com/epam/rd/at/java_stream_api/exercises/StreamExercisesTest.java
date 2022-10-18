package com.epam.rd.at.java_stream_api.exercises;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamExercisesTest {

    @Test
    void generateNumbers() {
        int x = 5;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = StreamExercises.generateNumbers(x);
        assertEquals(expected, result, "Result is incorrect for generateNumbers, x=" + x);
    }

    @Test
    void findMostDistantDateFuture() {
        LocalDate expected = LocalDate.parse("2021-01-14");
        LocalDate anchor = LocalDate.parse("2021-01-10");
        LocalDate actual = StreamExercises.findMostDistantDate(anchor,
                expected,
                LocalDate.parse("2021-01-07"),
                LocalDate.parse("2021-01-13"),
                LocalDate.parse("2021-01-12"));
        assertEquals(expected, actual);
    }

    @Test
    void findMostDistantDatePast() {
        LocalDate expected = LocalDate.parse("2021-01-06");
        LocalDate anchor = LocalDate.parse("2021-01-10");
        LocalDate actual = StreamExercises.findMostDistantDate(anchor,
                LocalDate.parse("2021-01-07"),
                LocalDate.parse("2021-01-13"),
                expected,
                LocalDate.parse("2021-01-12"));
        assertEquals(expected, actual);
    }

    @Test
    void findMostDistantDateFutureMonth() {
        LocalDate expected = LocalDate.parse("2021-02-10");
        LocalDate anchor = LocalDate.parse("2021-01-10");
        LocalDate actual = StreamExercises.findMostDistantDate(anchor,
                LocalDate.parse("2021-01-07"),
                LocalDate.parse("2021-01-13"),
                LocalDate.parse("2021-01-12"),
                expected);
        assertEquals(expected, actual);
    }

    @Test
    void findMostDistantDateWithNoDates() {
        LocalDate anchor = LocalDate.parse("2021-01-10");
        LocalDate actual = StreamExercises.findMostDistantDate(anchor);
        assertNull(actual);
    }

    @Test
    void getOddElements() {
        List<Integer> originalList = Arrays.asList(1, 1, 5, 5, 3, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 5, 3);
        List<Integer> evenElements = StreamExercises.getOddElements(originalList);
        assertEquals(expected, evenElements, "Result is incorrect for getOddElements with list " + originalList);
    }

    @Test
    void countStringsWithUniqueCharacters() {
        List<String> originalList = Arrays.asList("hello", "world", "", "java", "computer");
        long result = StreamExercises.countStringsWithUniqueCharacters(originalList);
        assertEquals(2, result, "Result is incorrect for originalList: " + originalList);
    }

    @Test
    void sortByLengthDesc() {
        List<String> originalList = Arrays.asList("hello", "world!!", "11", "", "java");
        List<String> expected = Arrays.asList("world!!", "hello", "java", "11", "");
        List<String> actual = StreamExercises.sortByLengthDesc(originalList);
        assertEquals(expected, actual, "Result is incorrect for sortByLengthDesc with list " + originalList);
    }

    @Test
    void checkNoNegativeValuesPositive() {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 10, 123);
        boolean result = StreamExercises.checkNoNegativeValues(list);
        assertTrue(result, "Result is incorrect for checkNoNegativeValues with list " + list);
    }

    @Test
    void checkNoNegativeValuesNegative() {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 10, -1);
        boolean result = StreamExercises.checkNoNegativeValues(list);
        assertFalse(result, "Result is incorrect for checkNoNegativeValues with list " + list);
    }

    @Test
    void getRandomUniqueDates() {
        List<LocalDate> randomUniqueDates1 = StreamExercises.getRandomUniqueDates(2020, 10);
        List<LocalDate> randomUniqueDates2 = StreamExercises.getRandomUniqueDates(2020, 10);
        assertNotEquals(randomUniqueDates1, randomUniqueDates2);

        List<LocalDate> sortedUniqueList = new ArrayList<>(new TreeSet<>(randomUniqueDates1));
        assertEquals(sortedUniqueList, randomUniqueDates1);
        randomUniqueDates1.forEach(d -> assertEquals(2020, d.getYear()));
    }

    @Test
    void indexOfByPredicatePositive() {
        List<Integer> originalList = Arrays.asList(1, 1, 5, 5, 3, 2, 3, 4, 5);
        int result = StreamExercises.indexOfByPredicate(originalList, i -> i > 4);
        int expected = 2;
        assertEquals(expected, result, "Result is incorrect for indexOfByPredicate with sequence " + originalList);
    }

    @Test
    void indexOfByPredicateNegative() {
        List<Integer> originalList = Arrays.asList(1, 1, 5, 5, 3, 2, 3, 4, 5);
        int result = StreamExercises.indexOfByPredicate(originalList, i -> i < 0);
        int expected = -1;
        assertEquals(expected, result, "Result is incorrect for indexOfByPredicate with sequence " + originalList);
    }

    @Test
    void generateMonthAndLengths() {
        Map<Month, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Month.JANUARY, 7);
        expectedMap.put(Month.FEBRUARY, 8);
        expectedMap.put(Month.MARCH, 5);
        expectedMap.put(Month.APRIL, 5);
        expectedMap.put(Month.MAY, 3);
        expectedMap.put(Month.JUNE, 4);
        expectedMap.put(Month.JULY, 4);
        expectedMap.put(Month.AUGUST, 6);
        expectedMap.put(Month.SEPTEMBER, 9);
        expectedMap.put(Month.OCTOBER, 7);
        expectedMap.put(Month.NOVEMBER, 8);
        expectedMap.put(Month.DECEMBER, 8);
        Map<Month, Integer> map = StreamExercises.generateMonthAndLengths();
        assertEquals(expectedMap, map);
    }

    @Test
    void findMostFrequentChar() {
        String string = "Hello world! I'm the best string ever!";
        char mostFrequentChar = StreamExercises.findMostFrequentChar(string);
        assertEquals('e', mostFrequentChar, "Wrong result of getValuesAndSort for " + string);
    }

    @Test
    void getValuesAndSort() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "3");
        map1.put("aaa", "4");
        map1.put("a1", "hello");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "world");
        map2.put("aaa", "33");
        map2.put("a1", "32");
        List<Map<String, String>> list = Arrays.asList(map1, map2);
        List<String> resultMap = StreamExercises.getValuesAndSort(list);
        List<String> expected = Arrays.asList("3", "4", "32", "33", "hello", "world");
        assertEquals(expected, resultMap, "Wrong result of getValuesAndSort for " + list);
    }
}