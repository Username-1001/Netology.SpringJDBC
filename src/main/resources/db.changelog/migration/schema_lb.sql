SET SCHEMA 'spring_jdbc';

CREATE TABLE IF NOT EXISTS customers
(
    id           serial primary key,
    name         varchar(30) NOT NULL ,
    surname      varchar(30) NOT NULL ,
    age          int2 CHECK ( age > 0 ),
    phone_number varchar(20)
);

CREATE TABLE IF NOT EXISTS orders
(
    id           serial primary key,
    date         date NOT NULL ,
    customer_id  int references customers (id),
    product_name varchar(255) NOT NULL ,
    amount       int CHECK ( amount > 0 )
);

INSERT INTO customers (name, surname, age, phone_number)
VALUES ('alexey', 'Vasin', 26, '890012578963'),
       ('Petya', 'Petin', 27, '890012578963'),
       ('Ivan', 'Ivanov', 28, '890012578963'),
       ('Poligraf', 'Poligrafov', 29, '890012578963');

INSERT INTO orders (date, customer_id, product_name, amount)
VALUES ('20230301', 1, 'product1', 2),
       ('20230303', 1, 'product3', 4),
       ('20230402', 2, 'product2', 1),
       ('20230425', 4, 'product4', 3);