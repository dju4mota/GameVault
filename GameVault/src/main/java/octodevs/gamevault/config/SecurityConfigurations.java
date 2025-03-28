package octodevs.gamevault.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    
    @Autowired
    SecurityFilter securityFilter;

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

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()                
                .requestMatchers("/reviews").authenticated()            
                .requestMatchers("/reviews/*").authenticated()            
                .requestMatchers("/reviews/*/*").authenticated()            
                .requestMatchers("/users").authenticated()
                .requestMatchers("/users/*").authenticated()
                .requestMatchers("/users/*/*").authenticated()
                .requestMatchers(HttpMethod.GET,"/games*").authenticated()
                .requestMatchers(HttpMethod.POST,"/games*").hasRole("ADMIN")
                .anyRequest().denyAll()
                )
            .csrf((csrf) -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
                
        return http.build();
    }
}
