import { View, Text, Image, FlatList, StyleSheet } from "react-native";
import ContainerPerfilTitulo from "./containerPerfilTitulo";
import { ResponseDTO } from "../models/dto/ResponseDto";
import { TouchableOpacity } from "react-native";
import { RelativePathString, useRouter } from "expo-router";
import { ReviewData } from "../models/ReviewData";


const Review :React.FC<ResponseDTO> = ({review,game, user}) => {

    const router = useRouter();
    
    const navega = (review: ResponseDTO) => {
        router.push({
            pathname: "/screens/reviewDetails",
            params: { review: JSON.stringify(review) },
            });
        };

    return (
    <View>
        <ContainerPerfilTitulo titulo={game.title} perfil={user}/>
        <View  style={styles.containerNota}>
            <Text  style={styles.textoNota}> Nota: {review.score}/5</Text>
        </View>         
        <TouchableOpacity onPress={()=> {navega({review,game,user})}} style={styles.containerGeral}>
            <Image source={require("@/assets/images/persona5.jpg")  } style={styles.imageReview} />
            <Text style={styles.textoReview}>{review.comment}</Text>
        </TouchableOpacity>
        
    </View>
    )
}

export default Review


const styles = StyleSheet.create({
    imagePerfil:{
        height:30,
        width:30,
        borderRadius: 30,
    }, 
    containerTitulo:{
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
        marginTop: 30,
        marginLeft: 20,
        marginRight: 10,
        height: 30
    },
    containerPerfil:{
        flexDirection: "row",
        justifyContent: "space-between",
        width: 115,        
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
    },
    containerNota:{
        marginLeft:20,
        width: 65,                
        // backgroundColor: "rgb(10,10,10)",
    },
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 14
    },
    textoPerfil:{
        fontSize: 12,
        color: "rgb(255, 255, 255)",
    },
    textoNota:{
        fontSize: 11,
        color: "rgb(248, 188, 120)",
    },
    imageReview:{
        // paddingTop: 50,
        width: 100,
        height: 100,
        marginTop: 10,
        
    },
    containerGeral:{
        flexDirection: "row",
        //justifyContent: "space-between",
        paddingTop: 5,
        marginLeft: 20,
        marginRight: 20,
        // alignItems: "center",
        // backgroundColor: "rgb(158, 207, 42)",
    },
    textoReview:{
        color: "rgb(160, 158, 158)",
        width: 250,
        paddingLeft: 30,
    }
});