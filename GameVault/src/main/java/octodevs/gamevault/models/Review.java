package octodevs.gamevault.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import octodevs.gamevault.dto.DtoPostReview;


//@Getter
//@Setter
@Entity
public class Review {
    @Id
    private long reviewId;
    private int score;
    private String comment;
    private String data;
    @Embedded
    private Game game;

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
        //this.game = review.game();
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
