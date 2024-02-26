package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.dto.q456.FruitAmountResponse;
import com.group.libraryapp.assignment.dto.q456.FruitInfRequest;
import com.group.libraryapp.assignment.dto.q456.FruitSoldRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysql")
public class FruitMysqlRepository implements FruitRepository{

    private final JdbcTemplate jdbcTemplate;

    public FruitMysqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addFruit(FruitInfRequest request){
        String sql = "INSERT INTO fruit(name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Override
    public void isSoldFruit(FruitSoldRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ? and is_sold = false";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE fruit SET is_sold = true WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @Override
    public FruitAmountResponse checkSalesAmount(String name) {
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
