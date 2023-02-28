package com.yurii.testtask;

import com.yurii.testtask.datesorter.DateSorter;
import com.yurii.testtask.datesorter.IDateSorter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DateSorterMain {

    public static void main(String[] args) {
        IDateSorter dateSorter = new DateSorter();
        Collection<LocalDate> sortedDates = dateSorter.sortDates(prepareDates());
        System.out.println(sortedDates);
    }
    
    private static List<LocalDate> prepareDates() {
        return Arrays.asList(
                LocalDate.of(2022, 1, 2),
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2022, 3, 1),
                LocalDate.of(2022, 4, 1),
                LocalDate.of(2022, 5, 1),
                LocalDate.of(2022, 6, 1),
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 8, 1),
                LocalDate.of(2022, 9, 1),
                LocalDate.of(2022, 10, 1),
                LocalDate.of(2022, 11, 1),
                LocalDate.of(2021, 7, 2),
                LocalDate.of(2022, 12, 1)
            );
    }

}
