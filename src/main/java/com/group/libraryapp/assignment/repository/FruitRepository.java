package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import org.springframework.beans.factory.annotation.Qualifier;


public interface FruitRepository {

    void addFruit(FruitInfRequest request);

    void isSoldFruit(FruitSoldRequest request);

    FruitAmountResponse checkSalesAmount(String name);
}
