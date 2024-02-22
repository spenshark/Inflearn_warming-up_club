package com.group.libraryapp.assignment.dto.q456;

import java.time.LocalDate;

public class FruitInfRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public String getName() {
        return name;
    }
    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
    public long getPrice() {
        return price;
    }
}
