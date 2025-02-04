package octodevs.gamevault.config;


import octodevs.gamevault.models.Game;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.repository.RepositoryReview;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(RepositoryReview reviewRepository) {
        return args -> {
            // Insere dados iniciais
            reviewRepository.save(new Review(1, 9, "Um jogo incrível com uma narrativa emocionante!", "2025-01-19",
                    new Game("The Legend of Zelda: Breath of the Wild", "Explore um vasto mundo aberto cheio de mistérios e aventuras.", "Action-Adventure"),
                    120.5f, "Nintendo Switch" ));
            reviewRepository.save(new Review(2, 8, "Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo.", "2025-01-18",
                    new Game("Horizon Forbidden West", "Acompanhe Aloy em uma jornada épica para salvar a Terra de uma nova ameaça.", "RPG"), 120.5f, "PlayStation 5"));
            reviewRepository.save(new Review(4, 7, "Boa jogabilidade, mas com problemas de performance no PC.", "2025-01-15",
                    new Game("Cyberpunk 2077","Explore uma cidade futurista em um mundo aberto repleto de escolhas.", "Action RPG"),
                    30f, "PC" ));
        };
    }
}