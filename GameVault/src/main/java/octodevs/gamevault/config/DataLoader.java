package octodevs.gamevault.config;

import jakarta.annotation.PostConstruct;
import octodevs.gamevault.models.Game;
import octodevs.gamevault.models.Review;
import octodevs.gamevault.models.UserAccount;
import octodevs.gamevault.repositories.dto.game.GameDtoEntrada;
import octodevs.gamevault.repositories.dto.game.GameDtoSaida;
import octodevs.gamevault.repositories.dto.review.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.user.UserDtoEntrada;
import octodevs.gamevault.repositories.dto.user.UserDtoOut;
import octodevs.gamevault.services.GameService;
import octodevs.gamevault.services.JsonFileReader;
import octodevs.gamevault.services.ReviewService;
import octodevs.gamevault.services.UserService;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* A Classe responsável por carregar os dados iniciais no banco. 
* Lê os 3 Jsons em resources/scripts e chama os respectivos Services.
* É ativada apenas no perfil Dev
*/

// @Component
@Profile("dev")
public class DataLoader {

    public final JsonFileReader jsonFileReader;
    private final GameService gameService;
    private final ReviewService reviewService;
    private final UserService userService;

    public DataLoader(JsonFileReader jsonFileReader, GameService gameService, ReviewService reviewService, UserService userService) {
        this.jsonFileReader = jsonFileReader;
        this.gameService = gameService;
        this.reviewService = reviewService;
        this.userService = userService;        
    }

    @PostConstruct
    public void loadData( ) {

        List<Game> games = jsonFileReader.readArrayGameFromJson("InitialDataGame.json");
        List<GameDtoSaida> idsGame = new ArrayList<GameDtoSaida>();

        for (Game game : games) {
            idsGame.add(gameService.createGame(new GameDtoEntrada(game.getTitle(), game.getDescription(), game.getGenre(),game.getPhoto())));    
        }
        

        List<UserAccount> users = jsonFileReader.readArrayUserFromJson("InitialDataUser.json");
        List<UserDtoOut> idsUsers = new ArrayList<UserDtoOut>();

        for (UserAccount user : users) {
            idsUsers.add(userService.createUserEncrypted(new UserDtoEntrada(user.getUserName(), user.getPassword(), user.getProfilePicture())));    
        }
        


        List<Review> reviews = jsonFileReader.readArrayReviewFromJson("InitialDataReview.json");
        Random rand = new Random();

        for (Review review : reviews) {
            int idG = rand.nextInt(idsGame.size());
            int idU = rand.nextInt(idsUsers.size());
            
            reviewService.createReview(new ReviewDtoEntrada(review.getScore(),review.getComment(),review.getData(),
            review.getPlatform(),review.getHoursPlayed(), idsGame.get(idG).gameId(), idsUsers.get(idU).userId()));
            // review.getPlatform(),review.getHoursPlayed(), idsGame.get(idG).gameId(), "111111111111111111"));
        }

        
    }
}
