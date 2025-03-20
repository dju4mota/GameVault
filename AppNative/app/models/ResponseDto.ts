import { GameData } from "./GameData";
import { ReviewData } from "./ReviewData";
import { UserData } from "./UserData";

export interface ResponseDTOInterface{
    review: ReviewData;
    user: UserData;
    game: GameData;
}

export class ResponseDTO{
    review: ReviewData
    user: UserData;
    game: GameData;

     constructor(data: ResponseDTOInterface) {
        this.review = data.review
        this.user = data.user
        this.game = data.game
     }

}