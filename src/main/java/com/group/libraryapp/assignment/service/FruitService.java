package com.group.libraryapp.assignment.service;

import com.group.libraryapp.assignment.dto.q456.Fruit;
import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import com.group.libraryapp.assignment.repository.FruitRepository;
import com.group.libraryapp.assignment.repository.FruitRepositoryV1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void addFruit(FruitInfRequest request){
        fruitRepository.save(
                new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    public void isSoldFruit(FruitSoldRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalAccessError::new);
        fruit.setIs_sold(true);
        fruitRepository.save(fruit);
    }

    public FruitAmountResponse checkSalesAmount(String name) {
        List<Fruit> fruits = fruitRepository.findAllByName(name);

        long salesAmount = 0;
        long notSalesAmount = 0;

        for(Fruit fruit : fruits){
            if(fruit.isIs_sold())
                salesAmount += fruit.getPrice();
            if(!fruit.isIs_sold())
                notSalesAmount += fruit.getPrice();
        }


        return new FruitAmountResponse(salesAmount, notSalesAmount);
    }
}
