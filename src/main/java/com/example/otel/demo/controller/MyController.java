package com.example.otel.demo.controller;

import com.example.otel.demo.model.Countries;
import com.example.otel.demo.model.Response;
import com.example.otel.demo.service.MyService;
import io.opentelemetry.api.trace.Span;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/wish/{name}")
    public CompletableFuture<Response> sayHello(@PathVariable("name") String name){

        return myService.wish(name);
    }

    @GetMapping("/countries/{number}")

    public CompletableFuture<List<Countries>> get(@PathVariable("number") Integer number){
        System.out.println(Span.current().getSpanContext());
        return myService.getAll(number);
    }
}
