package oo2.agricultura;

import oo2.agricultura.model.Vegetables;
import oo2.agricultura.repositories.VegetablesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgriculturaApplication {


    public static void main(String[] args) {
        SpringApplication.run(AgriculturaApplication.class, args);
    }

}
