package com.example.sums.repository;

import com.example.sums.model.Calculation;
import org.springframework.data.repository.CrudRepository;

public interface CalculationRepository extends CrudRepository<Calculation, Long> {
}