package com.group.libraryapp.assignment.dto.q2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekResponse {
    private DayOfWeek datOfTheWeek;

    public WeekResponse(LocalDate day) {
        this.datOfTheWeek = day.getDayOfWeek();
    }

    public DayOfWeek getDatOfTheWeek() {
        return datOfTheWeek;
    }
}
