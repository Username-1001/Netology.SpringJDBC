package ru.netology.springjdbc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers", schema = "spring_jdbc")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Check(constraints = "age > 0")
    private int age;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Order> orders;
}
