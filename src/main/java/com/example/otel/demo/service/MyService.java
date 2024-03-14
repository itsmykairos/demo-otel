package com.example.otel.demo.service;

import com.example.otel.demo.dao.CountriesDao;
import com.example.otel.demo.model.Countries;
import com.example.otel.demo.model.Response;
import io.opentelemetry.api.trace.Span;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;


@Service
public class MyService {
    private final CountriesDao countriesDao;
    private final ExecutorService executorService;

    public MyService(CountriesDao countriesDao, ExecutorService executorService) {
        this.countriesDao = countriesDao;
        this.executorService = executorService;
    }


    public CompletableFuture<List<Countries>> getAll(int num){

        var op=  CompletableFuture.supplyAsync(() -> countriesDao.getALl(num), executorService);
        System.out.println(Span.current().getSpanContext());
        return op;
    }

    public CompletableFuture<Response> wish(String name) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Span.current().setAttribute("sleeping", 2000);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Response.builder().message("Hello " + name).build();
        });
    }


}
