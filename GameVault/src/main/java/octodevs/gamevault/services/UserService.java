package octodevs.gamevault.services;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import octodevs.gamevault.models.UserAccount;
import octodevs.gamevault.repositories.UserRepository;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;

/**
 * A classe User Service manipula os dados de User.
 * Utiliza UserRepository para operar no banco. 
 * Recebe Dtos de entrada e cria Dtos de saída
 */
@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDtoOut createUser(UserDtoEntrada dtoEntrada) {
        
        UserDtoOut dtoSaida = new UserDtoOut(userRepository.save(new UserAccount(dtoEntrada)));
        return dtoSaida;
    }

    @Transactional
    public UserDtoOut createUserEncrypted(UserDtoEntrada dtoEntrada) {
        String encryptPassword = new BCryptPasswordEncoder().encode(dtoEntrada.password());        
        UserDtoOut dtoSaida = new UserDtoOut(userRepository.save(new UserAccount(dtoEntrada, encryptPassword)));
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
        try {                    
            UserAccount user = userRepository.getReferenceById(userId);
            if(user != null){
                user.addReview(reviewId);
                userRepository.save(user);
            }
        } catch (Exception e) {
            System.out.println("User Not Found");
        }

    }
}
