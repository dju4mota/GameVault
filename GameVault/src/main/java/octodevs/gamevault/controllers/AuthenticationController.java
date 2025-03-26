package octodevs.gamevault.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import octodevs.gamevault.models.UserAccount;
import octodevs.gamevault.repositories.UserRepository;
import octodevs.gamevault.repositories.dto.AuthenticationDTO;
import octodevs.gamevault.repositories.dto.LoginResponseDTO;
import octodevs.gamevault.repositories.dto.RegisterDTO;
import octodevs.gamevault.services.TokenService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto ){
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.userName(), dto.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        
        var token = tokenService.generateToken((UserAccount)auth.getPrincipal());
        
        return ResponseEntity.ok( new LoginResponseDTO(token));
    }

    // To Do -> Tirar opção de passar a role de amin pelo DTO 
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto){
        if(this.userRepository.findByUserName(dto.userName()) != null){
            return ResponseEntity.badRequest().build();
        } 
        String encryptPassword = new BCryptPasswordEncoder().encode(dto.password());
        UserAccount user = new UserAccount(dto.userName(), encryptPassword, dto.role());
        
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }

}
