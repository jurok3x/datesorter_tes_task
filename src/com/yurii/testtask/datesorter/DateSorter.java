package com.yurii.testtask.datesorter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter implements IDateSorter {

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Collection<LocalDate> sortedDates = unsortedDates.stream()
                .sorted(Comparator.comparing(LocalDate::getMonth, (m1, m2) -> { //separate month containing 'r'
                    if (m1.name().toLowerCase().contains("r") && !m2.name().toLowerCase().contains("r")) {
                        return -1;
                    } else if (!m1.name().toLowerCase().contains("r") && m2.name().toLowerCase().contains("r")) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).thenComparing((d1, d2) -> { //set month with 'r' ascending and otherwise descending
                    if(d1.getMonth().name().toLowerCase().contains("r")) {
                        return d1.compareTo(d2);
                    } else {
                        return d2.compareTo(d1);
                    }
                    }))
                .collect(Collectors.toList());
                return sortedDates;
    }

}
