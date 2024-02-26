package com.group.libraryapp.assignment.service;

import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import com.group.libraryapp.assignment.repository.FruitMysqlRepository;
import com.group.libraryapp.assignment.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(@Qualifier("memory") FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void addFruit(FruitInfRequest request){
        fruitRepository.addFruit(request);
    }

    public void isSoldFruit(FruitSoldRequest request) {
        fruitRepository.isSoldFruit(request);
    }

    public FruitAmountResponse checkSalesAmount(String name) {
        return fruitRepository.checkSalesAmount(name);
    }
}
