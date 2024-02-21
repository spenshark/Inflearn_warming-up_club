package com.group.libraryapp.assignment.controller;

import com.group.libraryapp.assignment.dto.q1.CalcResponse;
import com.group.libraryapp.assignment.dto.q1.NumberRequest;
import com.group.libraryapp.assignment.dto.q2.DateRequest;
import com.group.libraryapp.assignment.dto.q2.WeekResponse;
import com.group.libraryapp.assignment.dto.q3.NumListRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignmentController {

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
