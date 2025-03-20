import axios from 'axios';

const apiUrl = 'https://170.233.15.164:8080/reviews/complete';

// Função para buscar as reviews da API
const getReviews = async () => {
    try {
        const response = await axios.get(apiUrl);
        return response.data; // Retorna os dados da API
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
        throw error; // Lança o erro para ser tratado no componente
    }
};

// Exporta a função como default
export default getReviews;