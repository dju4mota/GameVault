import React, { useEffect, useState }  from "react";
import { View, StyleSheet} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Carrousel from "@/app/components/carrousel";
import BotaoPe from "@/app/components/botaoPe";
import { ApiService } from "@/services/ApiService";
import { GameUserResponseDto } from "../models/dto/ResponseDto";
import { GameData } from "../models/GameData";



export default function FeedGameScreen(){
    const [games, setGames] = useState<GameData[]>([]);

    // useEffect para chamar a função getReviews quando o componente for montado
    useEffect(() => {
        const fetchReviews = async () => {
            try {
                const data = await ApiService.get(5,ApiService.rotas.Games); // Chama a função do serviço
                setGames(data); // Atualiza o estado com os dados da API
            } catch (error) {
                console.error('Erro ao carregar reviews:', error);
            }
        };

        fetchReviews();
    },[]); // O array vazio garante que o useEffect só seja executado uma vez
    


return(
    <View  style={ styles.mainBody}>
       <Cabecalho activeItem={"Jogos"}/>
       <View  style={styles.carrousel}>
           <Carrousel texto={"Popular"} hasProfile={false} listaDados={games } />
            {/* To Do -> Recomendação de amigos*/}
           <Carrousel texto={"Entre amigos"} hasProfile={false} listaDados={games}/>           
       </View>  
       <BotaoPe/>
   </View>
    )
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
        backgroundColor: "rgb(36, 36, 36)"  
    }
  });