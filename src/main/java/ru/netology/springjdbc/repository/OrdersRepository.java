package ru.netology.springjdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrdersRepository {
    private final NamedParameterJdbcTemplate template;
    private final String requestScript;

    public OrdersRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
        requestScript = read("select_products_by_customer_name.sql");
    }


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String customerName) {
        return template.queryForList(requestScript, new MapSqlParameterSource("name", customerName), String.class);
    }
}
