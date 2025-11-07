package net.houcine.customerservice;

import net.houcine.customerservice.config.CustomerConfigParams;
import net.houcine.customerservice.entities.Customer;
import net.houcine.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("houcine").email("houcine@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("hamid").email("hamid@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("yassine").email("yassine@gmail.com")
                    .build());

            customerRepository.findAll().forEach(c ->{
                System.out.println("====================");
                System.out.println(c.toString());
                System.out.println("====================");
            });
        };
    }
}
