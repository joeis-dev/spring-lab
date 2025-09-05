package dev.joeis.spring.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This notation tells Spring to scan this package and subpackages to find beans.
 * External scans (i.e. in jars) can be achieve by setting scanBasePackageClasses attr
 * in the params of @SpringBootApplication(scanBasePackageClasses = {A.class, B.class and so on})*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
