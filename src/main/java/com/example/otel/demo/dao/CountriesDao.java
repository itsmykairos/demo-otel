package com.example.otel.demo.dao;

import com.example.otel.demo.model.Countries;
import com.example.otel.demo.repo.CountriesRepo;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class CountriesDao {

    private final CountriesRepo countriesRepo;


    public CountriesDao(CountriesRepo countriesRepo) {
        this.countriesRepo = countriesRepo;
    }

//    @WithSpan
    public List<Countries> getALl(int num){
        if(num%2 == 1){
            throw new RuntimeException("custom error");
        }
        return countriesRepo.findAll();
    }
}
