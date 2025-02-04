package octodevs.gamevault.crud;


import octodevs.gamevault.controllers.ReviewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ReviewController controller;

    //@Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/reviews",
                String.class)).contains("[{\"reviewId\":7,\"score\":8,\"comment\":\"Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo.\"," +
                "\"data\":\"2025-01-18\",\"platform\":\"PlayStation 5\",\"hoursPlayed\":45.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":" +
                "\"Acompanhe Aloy em uma jornada épica para salvar a Terra de uma nova ameaça.\",\"genre\":\"RPG\"}},{\"reviewId\":12,\"score\":8,\"comment\":" +
                "\"Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo.\",\"data\":\"2025-01-18\",\"platform\":\"PlayStation 5\",\"hoursPlayed" +
                "\":45.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":\"Acompanhe Aloy em uma jornada épica para salvar a Terra de uma nova ameaça.\"," +
                "\"genre\":\"RPG\"}},{\"reviewId\":19,\"score\":8,\"comment\":\"Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo.\",\"data\":null," +
                "\"platform\":null,\"hoursPlayed\":45.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":\"Acompanhe Aloy em uma jornada épica para salvar a " +
                "Terra de uma nova ameaça.\",\"genre\":\"RPG\"}},{\"reviewId\":30,\"score\":8,\"comment\":\"Um excelente jogo com gráficos impressionantes, mas um pouco repetitivo." +
                "\",\"data\":\"\",\"platform\":null,\"hoursPlayed\":45.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":\"Acompanhe Aloy em uma jornada épica para " +
                "salvar a Terra de uma nova ameaça.\",\"genre\":\"RPG\"}},{\"reviewId\":45,\"score\":7,\"comment\":\"Um excelente jogo com gráficos impressionantes, mas um " +
                "pouco repetitivo.\",\"data\":\"\",\"platform\":null,\"hoursPlayed\":5.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":\"Acompanhe Aloy em uma " +
                "jornada épica para salvar a Terra de uma nova ameaça.\",\"genre\":\"RPG\"}},{\"reviewId\":450,\"score\":8,\"comment\":\"Um excelente jogo com gráficos impressionantes," +
                " mas um pouco repetitivo.\",\"data\":\"\",\"platform\":null,\"hoursPlayed\":45.0,\"game\":{\"title\":\"Horizon Forbidden West\",\"description\":\"Acompanhe Aloy em uma" +
                " jornada épica para salvar a Terra de uma nova ameaça.\",\"genre\":\"RPG\"}}]");
    }


}