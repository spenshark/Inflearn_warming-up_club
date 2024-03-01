/*
package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.dto.q456.Fruit;
import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("memory")
public class FruitMemoryRepositoryV1 implements FruitRepositoryV1 {

    private List<Fruit> fruits = new ArrayList<>();
    private static Long id = 1L;

    @Override
    public void addFruit(FruitInfRequest request){
        fruits.add(new Fruit(id++, request.getName(), request.getWarehousingDate(), request.getPrice()));

    }

    @Override
    public void isSoldFruit(FruitSoldRequest request){
        Fruit fruit = fruits.get((int) request.getId()-1);
        if (!fruit.isIs_sold()) {
            fruit.setIs_sold(true);
        }
    }

    @Override
    public FruitAmountResponse checkSalesAmount(String name){

        long salesAmount = 0;
        long notSalesAmount = 0;

        for(Fruit fruit: fruits){
            if(fruit.getName().equals(name)){
                if(fruit.isIs_sold())
                    salesAmount += fruit.getPrice();
                else
                    notSalesAmount += fruit.getPrice();
            }
        }

        return new FruitAmountResponse(salesAmount, notSalesAmount);}

}
*/
