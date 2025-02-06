package octodevs.gamevault.entities.review;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import octodevs.gamevault.entities.game.Game;
import octodevs.gamevault.entities.review.dto.DtoPostReview;
import octodevs.gamevault.entities.review.dto.DtoPutReview;

@Entity
public class Review {
    @Id
    private long reviewId;
    private int score;
    private String comment;
    private String data;
    @Embedded
    private Game game;
    private float hoursPlayed;
    private String platform;


    public Review() {

    }

    public Review(long reviewId, int score, String comment, String data, Game game, float hoursPlayed, String platform) {
        this.reviewId = reviewId;
        this.score = score;
        this.comment = comment;
        this.data = data;
        this.game = game;
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
                ", game=" + game +
                '}';
    }

    public Review(DtoPostReview review) {
        this.comment = review.comment();
        this.score = review.score();
        this.data = review.data();
        this.reviewId = review.reviewId();
        this.platform = review.platform();
        this.hoursPlayed = review.hoursPlayed();
        this.game = new Game(review.game());
    }

    public void atualizarDados(DtoPutReview dadosReview) {
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

    public long getReviewId() {
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

    public Game getGame() {
        return game;
    }

    public float getHoursPlayed() {
        return hoursPlayed;
    }

    public String getPlatform() {
        return platform;
    }
}
