package com.thibaut.catservice;

import com.thibaut.catservice.dao.ProductRepository;
import com.thibaut.catservice.entities.AppRole;
import com.thibaut.catservice.entities.AppUser;
import com.thibaut.catservice.entities.Product;
import com.thibaut.catservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class);
        productRepository.save(new Product(null, "Computer", 6700, 5));
        productRepository.save(new Product(null, "Printer", 650, 2));
        productRepository.save(new Product(null, "SmartPhone", 2000, 5));

        productRepository.findAll().forEach(p-> {
            System.out.println(p.toString());
        });

        accountService.saveRole(new AppRole(null,"USER")); accountService.saveRole(new AppRole(null,"ADMIN")); accountService.saveUser("user","1234", "1234"); accountService.saveUser("admin","1234", "1234");
        accountService.addRoleToUser("user", "USER"); accountService.addRoleToUser("admin", "USER"); accountService.addRoleToUser("admin", "ADMIN");


    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
