import axios from 'axios';

export abstract class ApiService{

    // To Do Todas as rotas 
    static apiUrl = 'http://192.168.18.177:8080/';


    static rotas = { 
        ReviewsComplete: 'reviews/complete/',
        Games: 'games/',
        GamesByName: 'games/name/',
        Reviews: "reviews/",
        Users: "users/"
    };

    static async get(pages: number, url:string){
        try {
            var urlFull = this.apiUrl + url + "?size=" + pages;
            if(pages <= 0){
                urlFull = this.apiUrl + url;
            }          
            const response = await axios.get(urlFull);   
            return response.data.content;
        } catch (error) {
            console.error('Erro ao buscar dados:', error);
            throw error;
        }
    }

    static async post(){

    }
 
}


