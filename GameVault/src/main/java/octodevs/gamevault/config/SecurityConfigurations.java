package octodevs.gamevault.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import octodevs.gamevault.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    // @Bean
    // UserDetailsService userService(UserRepository repo) {
    //     return username -> repo.findByUserName(username);.asUser();
    // }

    // Expose AuthenticationManager as a bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // throws Exception {
        //     http.authorizeHttpRequests() //
        //      .requestMatchers("/login").permitAll() //
        //      .requestMatchers("/", "/search").authenticated() //
        //      .requestMatchers(HTTP, "/api/**")
        //      .authenticated() //
        //      .requestMatchers(, "/new-video",
        //         "/api/**").hasRole("ADMIN") //
        //      .anyRequest().denyAll() //
        //      .and() //
        //      .formLogin() //
        //     .and() //
        //     .httpBasic();
        // return http.build();

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/review/*").authenticated()
                .requestMatchers("/users/*").authenticated()
                .requestMatchers(HttpMethod.GET,"/games").authenticated()
                .requestMatchers(HttpMethod.POST,"/games").hasRole("ADMIN")
                .anyRequest().denyAll())
            .csrf((csrf) -> csrf.disable());
                
            // .httpBasic().and().formLogin() // deprecated
        
        
        return http.build();
    }
}
