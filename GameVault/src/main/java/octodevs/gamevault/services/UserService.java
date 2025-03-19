package octodevs.gamevault.services;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import octodevs.gamevault.models.User;
import octodevs.gamevault.repositories.UserRepository;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDtoOut createUser(UserDtoEntrada dtoEntrada) {
        
        UserDtoOut dtoSaida = new UserDtoOut(userRepository.save(new User(dtoEntrada)));
        return dtoSaida;
    }

    // Read    
    public Stream<UserDtoOut> getAllUsers(Pageable pageable) {    
        return userRepository.findAll(pageable).stream().map(UserDtoOut::new);
    }
    
    // get by Id    
    public UserDtoOut getUserById(String id) {        
        // TO DO mensagem de não encontrado 404
        return userRepository.findById(id).map(UserDtoOut::new).orElse(null);
    }


    @Transactional
    public void addReview(String userId, String reviewId){        
        User user = userRepository.getReferenceById(userId);
        user.addReview(reviewId);
        userRepository.save(user);
    }

}
