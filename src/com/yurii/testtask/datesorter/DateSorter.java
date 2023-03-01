package com.yurii.testtask.datesorter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter implements IDateSorter {

    private static final String CHARACTER = "r";

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Collection<LocalDate> sortedDates = unsortedDates.stream()
                //sorting dates: first comparing month names, after that dates in appropriate order
                .sorted(Comparator.comparing(LocalDate::getMonth, (m1, m2) -> compareMonthNames(m1, m2))
                        .thenComparing((d1, d2) -> compareDates(d1, d2)))
                .collect(Collectors.toList());
                return sortedDates;
    }
    
    private boolean containsR(Month month) {
        return month.name().toLowerCase().contains(CHARACTER);
    }
    
    private int compareMonthNames(Month m1, Month m2) {
        // comparing month names: sort months with 'r'
        if (containsR(m1) && !containsR(m2)) {
            return -1;
        } else if (!containsR(m1) && containsR(m2)) {
            return 1;
        } else {
            return 0; // if both months contain 'r' or none of them has one - assume months to be equal
        }
    }
    
    private int compareDates(LocalDate d1, LocalDate d2) {
        // if compareMonthNames() returns 0 than compare dates in appropriate order
        if(containsR(d1.getMonth())) {
            return d1.compareTo(d2); // for months with 'r' ascending order
        } else {
            return d2.compareTo(d1); // for months without 'r' descending order
        }
    }

}
