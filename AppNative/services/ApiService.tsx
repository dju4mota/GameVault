import axios from 'axios';


export abstract class ApiService{

    static apiUrl = 'http://192.168.18.177:8080/';
    //const apiUrl = 'http://127.0.0.1:8080/reviews/complete';

    // To Do -> Refatorar funções iguais
    // Get all reviews complete
    static async  getAllReviewsComplete (pages: number) {
        try {
            const response = await axios.get(this.apiUrl + "reviews/complete" + "?size=" + pages);
            return response.data.content; // Retorna os dados da API
        } catch (error) {
            console.error('Erro ao buscar dados:', error);
            throw error; // Lança o erro para ser tratado no componente
        }    
    };


    // To Do - Lógica para pegar dos amigos e os populares
    static async  getAllGames (pages: number) {
        try {
            const response = await axios.get(this.apiUrl + "games" + "?size=" + pages);
            return response.data.content; // Retorna os dados da API
        } catch (error) {
            console.error('Erro ao buscar dados:', error);
            throw error; // Lança o erro para ser tratado no componente
        }
    };
}


