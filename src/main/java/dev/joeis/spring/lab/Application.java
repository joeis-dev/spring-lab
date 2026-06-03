package dev.joeis.spring.lab;

import dev.joeis.spring.lab.consumingrest.Quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;
import org.springframework.boot.ApplicationRunner;


@SpringBootApplication
public class Application {

    // A desing pattern and utility that decouples the log logic bouding the current
    // class to a Log object.
    private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    // A utility that let us create a client with no UI 
    // on the backend to consume web services.
    @Bean
    @Profile("!test")
    public ApplicationRunner run(RestClient.Builder builder) {
        RestClient client = builder.baseUrl("http://localhost:8080").build();
        return args -> {
            Quote quote = client
                .get().uri("/api/random")
                .retrieve()
                .body(Quote.class);
            log.info(quote.toString());
        };
    }

}
