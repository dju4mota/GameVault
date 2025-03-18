import { GameData, GameDataInterface } from "./GameData";
import { UserData, UserDataInterface } from "./UserData";

export interface ReviewDataSimpleInterface {
    score: string;
    comment: string;
    user: UserDataInterface;
    game: GameDataInterface;
}

export interface ReviewDataInterface {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    user: UserDataInterface;
    game: GameDataInterface;
}

export class ReviewData {
    reviewId: string;
    score: string;
    comment: string;
    data: string;
    platform: string;
    hoursPlayed: string;
    user: UserData;
    game: GameData;

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