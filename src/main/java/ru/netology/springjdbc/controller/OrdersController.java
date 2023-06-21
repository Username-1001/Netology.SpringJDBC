package ru.netology.springjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springjdbc.repository.OrdersRepository;

import java.util.List;

@RestController
public class OrdersController {
    private final OrdersRepository repository;

    public OrdersController(OrdersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProduct(@RequestParam("name") String name) {
        return repository.getProductNameByUser(name);
    }
}
