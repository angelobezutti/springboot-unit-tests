package br.com.angelobezutti.api.service.impl;

import br.com.angelobezutti.api.domain.User;
import br.com.angelobezutti.api.repository.UserRepository;
import br.com.angelobezutti.api.service.UserService;
import br.com.angelobezutti.api.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
