package octodevs.gamevault.entities.user;


import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;
import octodevs.gamevault.entities.user.dto.LoginPostDTO;
import octodevs.gamevault.entities.user.dto.RegisterPostDTO;
import octodevs.gamevault.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    AuthenticationController(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginPostDTO loginPostDTO) {
        UsernamePasswordAuthenticationToken loginInfo = new UsernamePasswordAuthenticationToken(loginPostDTO.login(), loginPostDTO.password());
        Authentication auth = authenticationManager.authenticate(loginInfo);

        return ResponseEntity.ok(tokenService.generateToken((User) auth.getPrincipal()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterPostDTO registrationRequest) {
        //User user = userService.registerUser(registrationRequest);
        if(userRepository.existsByLogin(registrationRequest.login())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setLogin(registrationRequest.login());
        user.setPassword(passwordEncoder.encode(registrationRequest.password()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

}
