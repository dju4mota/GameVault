package octodevs.gamevault.repositories.dto.user;

import java.util.ArrayList;

import octodevs.gamevault.repositories.dto.review.ReviewDtoSaida;

public record UserDtoSaidaReviews(
    UserDtoOut user,
    ArrayList<ReviewDtoSaida> reviews
) {

}
