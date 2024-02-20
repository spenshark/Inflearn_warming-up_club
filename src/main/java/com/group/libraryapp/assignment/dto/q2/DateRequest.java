package com.group.libraryapp.assignment.dto.q2;

import java.time.LocalDate;

public class DateRequest {

    private String date;

    public DateRequest(String day) {
        this.date = day;
    }

    public LocalDate getDay() {
        return LocalDate.parse(date);
    }
}
