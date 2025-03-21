import React, { useEffect, useState } from 'react';
import { View, StyleSheet, ScrollView, Button} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";
import Linha from "../components/linha";
import { ResponseDTO } from '../models/ResponseDto';
import { ApiService } from '@/services/ApiService';


export default function FeedReviewScreen() {
    const [reviews, setReviews] = useState<ResponseDTO[]>([]);

    // useEffect para chamar a função getReviews quando o componente for montado
    useEffect(() => {
        const fetchReviews = async () => {
            try {
                const data = await ApiService.getAllReviewsComplete(10); // Chama a função do serviço
                setReviews(data); // Atualiza o estado com os dados da API                
            } catch (error) {
                console.error('Erro ao carregar reviews:', error);
            }
        };

        fetchReviews();
    },[]); // O array vazio garante que o useEffect só seja executado uma vez
    
    return (
        <View style={styles.mainBody}>
            <Cabecalho activeItem={"Reviews"} />            
            <ScrollView>
                {reviews.map((review, index) => (                    
                    <React.Fragment key={index}>
                        <Review                        
                            review={review.review}
                            game={review.game}                            
                            user={review.user}/>
                        <Linha />
                    </React.Fragment>
                ))}
            </ScrollView>
        </View>
    );
}

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