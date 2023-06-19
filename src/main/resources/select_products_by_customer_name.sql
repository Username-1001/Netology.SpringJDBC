select product_name
from spring_jdbc.customers as cust
         left join spring_jdbc.orders as ord
                   on cust.id = ord.customer_id
where lower(cust.name) = lower(:name)