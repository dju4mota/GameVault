
export interface ReviewDataInterface {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    user: string;
    game: string;
}

export class ReviewData {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    user: string;
    game: string;

    constructor(data: ReviewDataInterface) {
        this.reviewId = data.reviewId;
        this.score = data.score;
        this.comment = data.comment;
        this.data = data.data;
        this.platform = data.platform;
        this.hoursPlayed = data.hoursPlayed;
        this.user = data.user;
        this.game = data.game;
    }
}

