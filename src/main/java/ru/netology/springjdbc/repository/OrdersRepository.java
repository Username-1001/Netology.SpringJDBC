package ru.netology.springjdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.springjdbc.entity.Customer;

import java.util.List;

@Repository
public class OrdersRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getProductNameByUser(String customerName) {
        return entityManager.createQuery("SELECT c FROM Customer c WHERE lower(c.name) = lower(?1)", Customer.class)
                .setParameter(1, customerName)
                .getSingleResult()
                .getOrders()
                .stream()
                .map(o -> o.getProductName())
                .toList();
    }
}
