package br.octodevs.GameVault.model.review;

import br.octodevs.GameVault.utils.Platform;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    private Long score;
    private String comment;
    private String data;
    private Platform platform;
    private Long gameId;
    private Long userId;
    private Float hoursPlayed;

    protected Review() {
    }

    public Review(Long reviewId, Long score, String comment, String data, Platform platform, Long gameId, Long userId, Float hoursPlayed) {
        this.reviewId = reviewId;
        this.score = score;
        this.comment = comment;
        this.data = data;
        this.platform = platform;
        this.gameId = gameId;
        this.userId = userId;
        this.hoursPlayed = hoursPlayed;
    }

    public Review(ReviewDTO_Entrada review) {
        this.score = review.score();
        this.comment = review.comment();
        this.data = review.data();
        this.platform = review.platform();
        this.gameId = review.gameId();
        this.userId = review.userId();
        this.hoursPlayed = review.hoursPlayed();
    }

    //todo metodo para atualizar passando só os parametros a serem mudados


    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", data='" + data + '\'' +
                ", platform=" + platform +
                ", gameId=" + gameId +
                ", userId=" + userId +
                ", hoursPlayed=" + hoursPlayed +
                '}';
    }
}
