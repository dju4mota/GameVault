package octodevs.gamevault.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import octodevs.gamevault.dto.DtoPostReview;


@Getter
@Setter
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
        //this.game = review.game();
    }
}
