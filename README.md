# Collections

### Home task

In this task you needs to implements methods according to the task description next to the method.
This task should be implemented with Java 8 Stream API and lambdas.

1. Generates the list of integer numbers from 1 to X inclusive.
2. Having the array of `LocalDate` find an element which is earliest or the latest from the given one, depending on which period of lime is greater.
Example: input date 01-01-2022, array of dates [01-01-2020, 10-10-2022, 01-01-2023], result date is 01-01-2020 because it is two years (in past) distance from the given date
and it is greater than 01-01-2023 which is only one year (in future) distance.
3. Create a new list using the only odd position elements from the source list.
4. Having the list of strings, count the string elements which consist of unique symbols (please ignor the empty strings)
5. Having the list of strings, sort it by the string length in descending order.
6. Check that the list of integers contains no negative numbers.
7. Generate the given amount of the random and unique `LocalDate` in the given year, and sort them chronologically.
8. Find an index of the firs element in the collection, that meet the given criteria `Predicate`. If there is no such element please return -1.
9. Generate `Map<Month, Integer>`, using month names as a Map keys and the length of the month name for the current month as a corresponding value of this key.
Please use `java.time.Month` enum. Example result: `{MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ...`
10. Find the most frequent symbol in the given string (except for the space symbol) 
11. Having the `List<Map<String, String>>` create a list of all of the values that contains in all of the Maps of the original list of Maps. 
Sort the result list by the length of the string element and if two elements have the same length, sort them alphabetically.