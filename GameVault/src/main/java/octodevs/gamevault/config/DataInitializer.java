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
            reviewRepository.save(new Review(5, 10, "Experiência revolucionária na indústria de RPGs!", "2025-03-02",
                    new Game("Starfield Odyssey", "Um épico espacial com 100+ planetas exploráveis e narrativa não-linear.", "Sci-Fi RPG"),
                    85.5f, "Xbox Series X"));

            reviewRepository.save(new Review(6, 6, "Atmosfera incrível, mas combate frustrante.", "2025-02-28",
                    new Game("Eclipse of the Damned", "Sobrevivência horror em um mundo pós-apocalíptico infestado de zumbis.", "Survival Horror"),
                    22.0f, "PC"));

            reviewRepository.save(new Review(7, 3, "Microtransações arruínam a experiência.", "2025-03-01",
                    new Game("NBA Ultimate 2025", "Simulador de basquete com gráficos hiper-realistas.", "Sports"),
                    8.5f, "PlayStation 5"));

            reviewRepository.save(new Review(8, 9, "Estratégia complexa e rejogabilidade infinita.", "2025-02-27",
                    new Game("Civilization VII", "Construa um império desde a antiguidade até a era espacial.", "Strategy"),
                    300.0f, "PC"));

            reviewRepository.save(new Review(9, 8, "Perfeito para jogar em família.", "2025-03-05",
                    new Game("Super Mario Wonder 2", "Aventura colorida com novos power-ups e mundos criativos.", "Platformer"),
                    45.0f, "Nintendo Switch"));

            reviewRepository.save(new Review(10, 7, "Realismo impressionante, mas curva de aprendizado íngreme.", "2025-03-04",
                    new Game("Flight Simulator Ultimate", "Simulação de voo com mapas em tempo real e clima dinâmico.", "Simulation"),
                    18.0f, "Xbox Series S"));

            reviewRepository.save(new Review(11, 4, "Servidores instáveis e falta de conteúdo.", "2025-02-25",
                    new Game("Warzone: New Dawn", "Battle Royale futurista com 200 jogadores por partida.", "FPS"),
                    12.5f, "PC"));

            reviewRepository.save(new Review(12, 9, "Narrativa emocionante e personagens marcantes.", "2025-03-03",
                    new Game("The Last of Us: Reborn", "Remasterização com novo conteúdo pós-apocalíptico.", "Action-Adventure"),
                    60.0f, "PlayStation VR2"));

            reviewRepository.save(new Review(13, 5, "Conteúdo repetitivo após 10 horas.", "2025-02-26",
                    new Game("Assassin's Creed: Samurai", "Explore o Japão feudal com mecânicas de combate renovadas.", "Action RPG"),
                    15.0f, "PC"));

            reviewRepository.save(new Review(14, 10, "O ápice dos jogos de puzzle!", "2025-03-06",
                    new Game("Portal: Quantum Paradox", "Quebre as leis da física em quebra-cabeças dimensionais.", "Puzzle"),
                    32.5f, "Xbox Cloud Gaming"));

            reviewRepository.save(new Review(15, 2, "Otimização catastrófica para GPUs antigas.", "2025-03-07",
                    new Game("Cyber Revolution 2078", "Visão distópica de megacorporações e implantes cibernéticos.", "Action RPG"),
                    6.0f, "PC"));

            reviewRepository.save(new Review(16, 8, "Multiplayer caótico e divertido!", "2025-03-08",
                    new Game("Overwatch: Legacy", "Heróis clássicos em arenas redesenhadas.", "Hero Shooter"),
                    78.0f, "PlayStation 5"));

            reviewRepository.save(new Review(17, 7, "Campanha curta mas com ótima direção de arte.", "2025-03-09",
                    new Game("Hollow Knight: Silk Song", "Aventura metroidvania em um mundo de insetos sombrio.", "Metroidvania"),
                    25.5f, "Nintendo Switch"));

            reviewRepository.save(new Review(18, 0, "Jogo inacabado e cheio de bugs críticos.", "2025-03-10",
                    new Game("Rise of Titans", "MMO de batalha entre deuses mitológicos.", "MMORPG"),
                    2.0f, "Mobile"));

            reviewRepository.save(new Review(19, 9, "Inovador sistema de crafting e sobrevivência.", "2025-03-11",
                    new Game("Subnautica: Abyssal Zone", "Explore oceanos alienígenas profundos cheios de perigos.", "Survival"),
                    90.0f, "PC"));

            reviewRepository.save(new Review(20, 6, "Microtransações agressivas em jogo full-price.", "2025-03-12",
                    new Game("Need for Speed: Underground Revival", "Corridas urbanas com personalização extrema.", "Racing"),
                    18.5f, "Xbox Series X"));

            reviewRepository.save(new Review(21, 10, "O melhor JRPG da década!", "2025-03-13",
                    new Game("Final Fantasy XVII", "Jornada épica com sistema de combate por turnos revolucionário.", "JRPG"),
                    120.0f, "PlayStation 5"));

            reviewRepository.save(new Review(22, 8, "Ótimo para speedruns, mas difícil para casuals.", "2025-03-14",
                    new Game("Celeste: Ascension", "Plataforma desafiador com narrativa sobre saúde mental.", "Platformer"),
                    42.0f, "PC"));

            reviewRepository.save(new Review(23, 7, "Ideia criativa com execução mediana.", "2025-03-15",
                    new Game("Dreamweaver", "Crie e explore mundos gerados proceduralmente.", "Sandbox"),
                    30.0f, "Google Stadia"));

            reviewRepository.save(new Review(24, 1, "Pay-to-win descarado e progressão artificial.", "2025-03-16",
                    new Game("Dragon Arena", "Batalhas de dragões com elementos de gacha.", "Mobile RPG"),
                    4.5f, "iOS"));
        };
    }
}