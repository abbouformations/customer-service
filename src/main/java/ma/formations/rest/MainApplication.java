package ma.formations.rest;

import ma.formations.rest.dtos.customer.AddCustomerRequest;
import ma.formations.rest.service.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    @Bean
    CommandLineRunner initDataBase(ICustomerService customerService) {

        return args -> {
            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user_1").
                    identityRef("A100").
                    firstname("FIRST_NAME_1").
                    lastname("LAST_NAME_1").
                    build());

            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user_2").
                    identityRef("A200").
                    firstname("FIRST_NAME_2").
                    lastname("LAST_NAME_2").
                    build());

            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user_3").
                    identityRef("A300").
                    firstname("FIRST_NAME_3").
                    lastname("LAST_NAME_3").
                    build());

            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user_4").
                    identityRef("A400").
                    firstname("FIRST_NAME_4").
                    lastname("LAST_NAME_4").
                    build());
        };
    }
}
