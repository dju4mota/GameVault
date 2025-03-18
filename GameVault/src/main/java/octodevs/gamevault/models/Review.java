package octodevs.gamevault.models;


import jakarta.persistence.*;
import octodevs.gamevault.repositories.dto.ReviewDtoEntrada;
import octodevs.gamevault.repositories.dto.ReviewDtoPut;
import octodevs.gamevault.repositories.dto.ReviewDtoSaida;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reviewId;
    private int score;
    private String comment;
    private String data;
    private String platform;    
    private float hoursPlayed;    
    private String gameId;
    private String userId;
    
    public Review() {

    }

    public Review(String reviewId, int score, String comment, String data, String gameId, float hoursPlayed, String platform, String userId) {
        this.reviewId = reviewId;
        this.score = score;
        this.comment = comment;
        this.data = data;
        this.gameId = gameId;
        this.hoursPlayed = hoursPlayed;
        this.platform = platform;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", score=" + score +
                ", comment=" + comment+
                ", data=" + data + '\'' +
                ", platform=" + platform + '\'' +
                ", hoursPlayed=" + hoursPlayed + '\'' +
                ", gameId=" + gameId +
                ", userId=" + userId +
                '}';
    }

    public Review(ReviewDtoEntrada review) {
        this.comment = review.comment();
        this.score = review.score();
        this.data = review.data();
        this.platform = review.platform();
        this.hoursPlayed = review.hoursPlayed();
        this.gameId = review.gameId();
        this.userId = review.userId();
    }

    public Review(ReviewDtoSaida review) {
        this.reviewId = review.reviewId();
        this.comment = review.comment();
        this.score = review.score();
        this.data = review.data();
        this.platform = review.platform();
        this.hoursPlayed = review.hoursPlayed();
        this.gameId = review.gameId();
        this.userId = review.userId();
    }

    public void atualizarDados(ReviewDtoPut dadosReview) {
        if(dadosReview.comment() != null) {
            this.comment = dadosReview.comment();
        }
        if(dadosReview.data() != null) {
            this.data = dadosReview.data();
        }
        if(dadosReview.platform() != null) {
            this.platform = dadosReview.platform();
        }
        if(dadosReview.hoursPlayed() != 0) {
            this.hoursPlayed = dadosReview.hoursPlayed();
        }
        if (dadosReview.score() != 0) {
            this.score = dadosReview.score();
        }
    }

    public String getReviewId() {
        return reviewId;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public String getData() {
        return data;
    }

    public String getGameId() {
        return gameId;
    }

    public float getHoursPlayed() {
        return hoursPlayed;
    }

    public String getPlatform() {
        return platform;
    }

    public String getUserId() {
        return userId;
    }

}
