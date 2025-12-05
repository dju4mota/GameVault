package br.octodevs.GameVault.service;

import br.octodevs.GameVault.model.user.User;
import br.octodevs.GameVault.model.user.UserDTO_Entrada;
import br.octodevs.GameVault.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserDTO_Entrada review){
        return userRepository.save(new User(review));
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User updateById(Long id, User review){
        return userRepository.save(review);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
