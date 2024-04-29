package br.com.angelobezutti.api.service.impl;

import br.com.angelobezutti.api.domain.User;
import br.com.angelobezutti.api.domain.dto.UserDTO;
import br.com.angelobezutti.api.repository.UserRepository;
import br.com.angelobezutti.api.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdReturnAnUserInstance() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);

        var response = service.findById(1);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(1, response.getId());
        assertEquals("Angelo", response.getName());
        assertEquals("angelo@email.com", response.getEmail());

    }

    @Test
    void whenFindByIdThenAnObjectNotFoundException(){
        when(repository.findById(Mockito.anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));
        try {
            service.findById(1);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(1, "Angelo", "angelo@email.com", "12345");
        userDTO = new UserDTO(1, "Angelo", "angelo@email.com", "12345");
        optionalUser = Optional.of( new User(1, "Angelo", "angelo@email.com", "12345"));
    }
}