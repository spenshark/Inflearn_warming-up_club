package com.group.libraryapp.assignment.dto.q456;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate warehousingDate;
    @Column(nullable = false)
    private Long price;
    @Column
    private boolean is_sold;

    protected Fruit() {}

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
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
