import React, { useEffect, useState } from 'react';
import { View, StyleSheet, ScrollView, Button} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";
import Linha from "../components/linha";
import getReviews from '@/services/ApiService'; 
import { ResponseDTO } from '../models/ResponseDto';


export default function FeedReviewScreen() {
    const [reviews, setReviews] = useState<ResponseDTO[]>([]);

    // useEffect para chamar a função getReviews quando o componente for montado
    useEffect(() => {
        const fetchReviews = async () => {
            try {
                const data = await getReviews(); // Chama a função do serviço
                setReviews(data); // Atualiza o estado com os dados da API
                console.log(data)
            } catch (error) {
                console.error('Erro ao carregar reviews:', error);
            }
        };

        fetchReviews();
    },[]); // O array vazio garante que o useEffect só seja executado uma vez

    async function  api(){
        {
            try {
                const data = await getReviews(); // Chama a função do serviço
                setReviews(data); // Atualiza o estado com os dados da API
                console.log(reviews)
            } catch (error) {
                console.error('Erro ao carregar reviews:', error);
            }
        };
    }

    return (
        <View style={styles.mainBody}>
            <Cabecalho activeItem={"Reviews"} />
            <Button title='aaa' onPress={api} />
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