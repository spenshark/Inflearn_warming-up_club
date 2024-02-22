package com.group.libraryapp.assignment.dto.q456;

public class FruitAmountResponse {
    private long salesAmount;
    private long notSalesAmount;

    public FruitAmountResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
