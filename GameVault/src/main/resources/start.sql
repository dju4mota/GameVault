use gamevault;

CREATE TABLE IF NOT EXISTS review (
    reviewId INT PRIMARY KEY,
    score INT NOT NULL,
    comment TEXT,
    data DATE,
    hoursPlayed DECIMAL(10, 2),
    platform VARCHAR(100),
    gameTitle VARCHAR(255) NOT NULL,
    gameDescription TEXT,
    gameGenre VARCHAR(100)
);
INSERT INTO review (review_id, score, comment, data, hours_played, platform, title, description, genre) VALUES
                                                                                                             (1, 9, 'Um jogo incrível com uma narrativa emocionante!', '2025-01-19', 120.5, 'Nintendo Switch', 'The Legend of Zelda: Breath of the Wild', 'Explore um vasto mundo aberto cheio de mistérios e aventuras.', 'Action-Adventure'),
                                                                                                             (2, 8, 'Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo.', '2025-01-18', 45.0, 'PlayStation 5', 'Horizon Forbidden West', 'Acompanhe Aloy em uma jornada épica para salvar a Terra de uma nova ameaça.', 'RPG'),
                                                                                                             (3, 7, 'Boa jogabilidade, mas com problemas de performance no PC.', '2025-01-15', 30.0, 'PC', 'Cyberpunk 2077', 'Explore uma cidade futurista em um mundo aberto repleto de escolhas.', 'Action RPG');
