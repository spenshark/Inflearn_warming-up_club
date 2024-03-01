package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;


public interface FruitRepositoryV1 {

    void addFruit(FruitInfRequest request);

    void isSoldFruit(FruitSoldRequest request);

    FruitAmountResponse checkSalesAmount(String name);
}
