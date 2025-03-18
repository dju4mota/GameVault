export interface UserDataInterface{
    userId: string;
    userName: string;
    userPicture: string;
}


// Classe User
export class UserData {
    userId: string;
    userName: string;
    userPicture: string;
    //reviewsId: []string
    //gamesLists: []string
    //friends: []string

    constructor(data: UserDataInterface) {
        this.userId = data.userId;
        this.userName = data.userName;
        this.userPicture = data.userPicture;
    }
}

