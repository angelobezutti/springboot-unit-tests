package br.com.angelobezutti.api.config;

import br.com.angelobezutti.api.domain.User;
import br.com.angelobezutti.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Angelo", "angelo@email.com", "123");
        User u2 = new User(null, "Antonio", "antonio@email.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
