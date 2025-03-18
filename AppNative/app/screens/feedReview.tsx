import React, { useEffect, useState } from 'react';
import { View, StyleSheet, ScrollView} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";
import Linha from "../components/linha";
import getReviews from '@/services/ReviewService'; 
import { ReviewData } from '../models/ReviewData';
import { User } from '../models/UserData';



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
                            score={review.score} // Supondo que a API retorne um campo "nota"
                            game={review.game} // Supondo que a API retorne um campo "foto"
                            comment={review.comment} // Supondo que a API retorne um campo "texto"
                            user={new User(review.user.userId, review.user.userName, review.user.userPicture)} // Ajuste conforme a estrutura da API
                            reviewId={''} data={''} platform={''} hoursPlayed={''}
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