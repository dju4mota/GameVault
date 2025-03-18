import React, { useEffect, useState } from 'react';
import { View, StyleSheet, ScrollView} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";
import Linha from "../components/linha";
import PerfilData from "../models/PerfilData";
import getReviews from '@/services/ReviewService'; 

interface ReviewData {
    "reviewId": string
    "score": string
    "comment": string
    "data": string
    "platform": string
    "hoursPlayed":string
    "gameId": string
}


export default function FeedReviewScreen() {
    const [reviews, setReviews] = useState<ReviewData[]>([]);

    // useEffect para chamar a função getReviews quando o componente for montado
    useEffect(() => {
        const fetchReviews = async () => {
            try {
                const data = await getReviews(); // Chama a função do serviço
                setReviews(data); // Atualiza o estado com os dados da API
                console.log(reviews)
            } catch (error) {
                console.error('Erro ao carregar reviews:', error);
            }
        };

        fetchReviews();
    }, []); // O array vazio garante que o useEffect só seja executado uma vez

    return (
        <View style={styles.mainBody}>
            <Cabecalho activeItem={"Reviews"} />
            <ScrollView>
                {reviews.map((review, index) => (
                    <React.Fragment key={index}>
                        <Review
                            nota={review.score} // Supondo que a API retorne um campo "nota"
                            foto={review.gameId} // Supondo que a API retorne um campo "foto"
                            texto={review.comment} // Supondo que a API retorne um campo "texto"
                            perfil={new PerfilData(review.platform, review.data)} // Ajuste conforme a estrutura da API
                        />
                        <Linha />
                    </React.Fragment>
                ))}
            </ScrollView>
        </View>
    );
}




// export default function FeedReviewScreen(){
//     const [reviews, setReviews] = useState([]); // Estado para armazenar as reviews

//     // useEffect para chamar a função getReviews quando o componente for montado
//     useEffect(() => {
//         const fetchReviews = async () => {
//             try {
//                 const data = await getReviews(); // Chama a função do serviço
//                 setReviews(data); // Atualiza o estado com os dados da API
//                 console.log(reviews)
//             } catch (error) {
//                 console.error('Erro ao carregar reviews:', error);
//             }
//         };

//         fetchReviews();
//     }, []); // O array vazio garante que o useEffect só seja executado uma vez

// return(
//     <View  style={ styles.mainBody}>
//         <Cabecalho activeItem={"Reviews"}/>       
//         <ScrollView>
//             <Review nota={"5"} foto="" texto={reviews[0]} perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")}/>       
//             <Linha/>
//             <Review nota={"5"} foto="" texto="aaaaaaaaaaaaaaaaa" perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")}/>              
//             <Linha/>
//             <Review nota={"5"} foto="" texto="aaaaaaaaaaaaaaaaa" perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")}/>             
//             <Linha/>
//             <Review nota={"5"} foto="" texto="aaaaaaaaaaaaaaaaa" perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")}/>              
//        </ScrollView>       
//     </View>
//     )
// }


const styles = StyleSheet.create({
    carrousel: {
        // flex:1,
        justifyContent: "space-between",
        height: "60%",
        // backgroundColor: "#000"
    },
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)",  
        
    }
  });