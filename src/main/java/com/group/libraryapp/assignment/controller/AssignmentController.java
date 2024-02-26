package com.group.libraryapp.assignment.controller;

import com.group.libraryapp.assignment.dto.q1.CalcResponse;
import com.group.libraryapp.assignment.dto.q1.NumberRequest;
import com.group.libraryapp.assignment.dto.q2.DateRequest;
import com.group.libraryapp.assignment.dto.q2.WeekResponse;
import com.group.libraryapp.assignment.dto.q3.NumListRequest;
import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    private final JdbcTemplate jdbcTemplate;

    public AssignmentController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/v1/calc")
    public CalcResponse calculator(NumberRequest request) {
        return new CalcResponse(request.getNum1(), request.getNum2());
    }

    @GetMapping("/api/v1/week")
    public WeekResponse getWeek(DateRequest day) {
        return new WeekResponse(day.getDay());
    }

    @PostMapping("/api/v1/add")
    public int addNum(@RequestBody NumListRequest request) {
        return request.getNumbers().stream().mapToInt(i -> i).sum();
    }


}
