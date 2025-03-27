import { View, Text, Image, FlatList, StyleSheet } from "react-native";
import ContainerPerfilTitulo from "./containerPerfilTitulo";
import { ResponseDTO } from "../models/dto/ResponseDto";
import { TouchableOpacity } from "react-native";
import { RelativePathString, useRouter } from "expo-router";
import { ReviewData } from "../models/ReviewData";
import { GameData } from "../models/GameData";


const Game :React.FC<GameData> = (game) => {

    const router = useRouter();
    
    const navega = (game: GameData) => {      
        router.push({
            pathname: "/screens/gameDetails",
            params: { game: JSON.stringify(game) },
        });
    };

    return (
    <View>        
        <TouchableOpacity onPress={()=> {navega(game)}} style={styles.containerGeral}>
            <Image source={require("@/assets/images/persona5.jpg")  } style={styles.imageReview} />
        <View style={styles.containerTitulo}>
            <Text style={styles.textoTitulo}>{game.title}</Text>
            <Text style={styles.textoReview}>{game.description}</Text>
        </View>    
        </TouchableOpacity>
        
    </View>
    )
}

export default Game


const styles = StyleSheet.create({

    containerTitulo:{
        justifyContent: "space-between",        
        // backgroundColor: "rgb(10,10,10)",
        marginTop: 30,
        marginLeft: 20,
        marginRight: 10,        
        width: '70%'
    },        
    textoTitulo:{
        color: "rgb(170, 169, 169)",
        fontSize: 18
    },    
    imageReview:{
        // paddingTop: 50,
        width: 100,
        height: 100,
        marginTop: 10,
        
    },
    containerGeral:{
        flexDirection: "row",
        paddingTop: 5,
        marginLeft: 20,
        marginRight: 20,    
    },
    textoReview:{
        color: "rgb(160, 158, 158)",
        
    }
});