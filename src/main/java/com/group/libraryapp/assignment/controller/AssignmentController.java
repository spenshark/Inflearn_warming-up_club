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

    @PostMapping("/api/v1/fruit")
    public void addFruit(@RequestBody FruitInfRequest request) {
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void isSoldFruit(@RequestBody FruitSoldRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ? and is_sold = false";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE fruit SET is_sold = true WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitAmountResponse checkSalesAmount(@RequestParam String name) {
        String readSql = "SELECT * FROM fruit WHERE name = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }

        String soldSql = "SELECT sum(price) FROM fruit WHERE is_sold = true GROUP BY name having name = ?";
        String notSoldSql = "SELECT sum(price) FROM fruit WHERE is_sold = false GROUP BY name having name  = ?";

        long salesAmount = jdbcTemplate.queryForObject(soldSql, long.class, name);
        long notSalesAmount = jdbcTemplate.queryForObject(notSoldSql, long.class, name);

        return new FruitAmountResponse(salesAmount, notSalesAmount);
    }
}
