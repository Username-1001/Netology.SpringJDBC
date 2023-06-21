package ru.netology.springjdbc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "product_name")
    private String productName;
    @Check(constraints = "amount > 0")
    private int amount;
}
