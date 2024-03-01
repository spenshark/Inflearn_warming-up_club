package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.dto.q456.Fruit;
import com.group.libraryapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Optional<Fruit> findByName(String name);

    List<Fruit> findAllByName(String name);

}
