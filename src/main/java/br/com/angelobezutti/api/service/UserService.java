package br.com.angelobezutti.api.service;

import br.com.angelobezutti.api.domain.User;

public interface UserService {

    User findById(Integer id);

}
