package com.group.libraryapp.assignment.dto.q456;

import java.time.LocalDate;

public class Fruit {
    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean is_sold;


    public Fruit(long id, String name, LocalDate warehousingDate, long price) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.is_sold = false;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public boolean isIs_sold() {
        return is_sold;
    }

    public void setIs_sold(boolean is_sold) {
        this.is_sold = is_sold;
    }
}
