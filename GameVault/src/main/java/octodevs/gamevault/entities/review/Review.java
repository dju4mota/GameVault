package octodevs.gamevault.entities.review;


import jakarta.persistence.*;
import octodevs.gamevault.entities.game.Game;
import octodevs.gamevault.entities.review.dto.ReviewDtoPost;
import octodevs.gamevault.entities.review.dto.ReviewDtoPut;

import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reviewId;
    private int score;
    private String comment;
    private String data;
    private String gameId;
    private float hoursPlayed;
    private String platform;


    public Review() {

    }

    public Review(String reviewId, int score, String comment, String data, String gameId, float hoursPlayed, String platform) {
        this.reviewId = reviewId;
        this.score = score;
        this.comment = comment;
        this.data = data;
        this.gameId = gameId;
        this.hoursPlayed = hoursPlayed;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", data='" + data + '\'' +
                ", gameID=" + gameId +
                '}';
    }

    public Review(ReviewDtoPost review) {
        this.comment = review.comment();
        this.score = review.score();
        this.data = review.data();
        this.platform = review.platform();
        this.hoursPlayed = review.hoursPlayed();
        this.gameId = review.gameId();
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
}
