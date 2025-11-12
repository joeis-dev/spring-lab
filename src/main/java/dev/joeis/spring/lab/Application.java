package dev.joeis.spring.lab;

import dev.joeis.spring.lab.data.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    // A template class injected as bean component
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute(
            "CREATE TABLE customers(id SERIAL, first_name VARCHAR(255)," +
            "last_name VARCHAR(255))"
        );

        // Result = <["John", "Woo"], ...>
        List<Object[]> splitUpNames = Arrays.asList(
            "John Woo",
            "Jeff Dean",
            "Josh Bloch",
            "Josh Long"
        ).stream()
        .map(name -> name.split(" "))
        .collect(Collectors.toList());

        // Just feedback info
        splitUpNames.forEach(
            name -> log.info(String.format(
                "Inserting customer record for %s %s",
                name[0],
                name[1]
            ))
        );

        // ? placeholder helps to avoid sql injection
        // use batchUpdate when 1+ entries will be modified 
        jdbcTemplate.batchUpdate(
            "INSERT INTO customers(first_name, last_name) " +
            "VALUES (?, ?)", splitUpNames
        );

        log.info(
            "Querying for customer records where first_name = 'Josh':"
        );

        jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers " +
            "WHERE first_name = ?",
            (result, rowNumber) -> new Customer(
                result.getLong("id"),
                result.getString("first_name"),
                result.getString("last_name")
                ), 
            "Josh"
        ).forEach(customer -> log.info(customer.toString()));

    }

}
