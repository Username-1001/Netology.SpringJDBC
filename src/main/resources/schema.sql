DROP SCHEMA IF EXISTS spring_jdbc CASCADE;
CREATE SCHEMA IF NOT EXISTS spring_jdbc;

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