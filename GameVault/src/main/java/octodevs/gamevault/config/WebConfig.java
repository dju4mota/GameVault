package octodevs.gamevault.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements  WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TO DO adicionar configurações de segurança 
        registry.addMapping("/**") // Altere para o mapeamento correto se necessário
                .allowedOrigins("*") // URL do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todos os headers
                .allowCredentials(false); // Permite credenciais
    }
}
