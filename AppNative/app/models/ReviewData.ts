import { Game } from "./GameData";
import { User } from "./UserData";

export interface ReviewDataInterface {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    gameId: string;
    user: User;
    game: Game;
}

export class ReviewData {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    user: User;
    game: Game;

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