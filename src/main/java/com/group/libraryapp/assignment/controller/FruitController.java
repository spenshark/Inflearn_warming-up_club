package com.group.libraryapp.assignment.controller;

import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import com.group.libraryapp.assignment.service.FruitService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/fruit")
@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping()
    public void addFruit(@RequestBody FruitInfRequest request) {
        fruitService.addFruit(request);
    }

    @PutMapping()
    public void isSoldFruit(@RequestBody FruitSoldRequest request) {
        fruitService.isSoldFruit(request);
    }

    @GetMapping("/stat")
    public FruitAmountResponse checkSalesAmount(@RequestParam String name) {
        return fruitService.checkSalesAmount(name);
    }
}
