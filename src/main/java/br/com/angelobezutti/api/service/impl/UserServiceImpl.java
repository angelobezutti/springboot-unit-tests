package br.com.angelobezutti.api.service.impl;

import br.com.angelobezutti.api.domain.User;
import br.com.angelobezutti.api.domain.dto.UserDTO;
import br.com.angelobezutti.api.repository.UserRepository;
import br.com.angelobezutti.api.service.UserService;
import br.com.angelobezutti.api.service.exception.DataIntegratyViolationException;
import br.com.angelobezutti.api.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema");
        }
    }
}
