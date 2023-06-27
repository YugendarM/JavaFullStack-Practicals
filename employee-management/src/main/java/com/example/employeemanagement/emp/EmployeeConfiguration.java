package com.example.employeemanagement.emp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee Sridhar = new Employee(
                    1L,
                    "Sridhar",
                    LocalDate.of(1998, Month.JUNE,21),
                    "sridhar@gmail.com"
            );

            Employee Mehta = new Employee(
                    2L,
                    "Mehta",
                    LocalDate.of(1996, Month.AUGUST,18),
                    "mehta@gmail.com"
            );

            employeeRepository.saveAll(List.of(Sridhar,Mehta));
        };
    }
}


@Configuration
 class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
