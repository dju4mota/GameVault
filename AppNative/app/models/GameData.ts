export interface GameDataInterface
{
    gameId: string
    title: string;
    description: string;
    genre: string;
    photo: string;
}


// Classe Game
export class GameData {
    gameId: string
    title: string;
    description: string;
    genre: string;
    photo: string;
    //reviewsIds: []string

    constructor(data: GameDataInterface) {
        this.gameId = data.gameId;
        this.title = data.title;
        this.description = data.description;
        this.genre = data.genre;
        this.photo = data.photo;
    }
}