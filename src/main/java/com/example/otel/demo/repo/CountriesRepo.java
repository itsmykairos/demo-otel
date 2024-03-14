package com.example.otel.demo.repo;

import com.example.otel.demo.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepo extends JpaRepository<Countries, Long> {
}
