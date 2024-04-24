package br.com.angelobezutti.api.repository;

import br.com.angelobezutti.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
