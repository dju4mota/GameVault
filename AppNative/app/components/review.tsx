import { View, Text, Image, FlatList, StyleSheet } from "react-native";
import ContainerPerfilTitulo from "./containerPerfilTitulo";
import { ReviewDataSimpleInterface } from "../models/ReviewData";


const Review :React.FC<ReviewDataSimpleInterface> = ({score,comment,game, user}) => {
    return (
    <View>
        <ContainerPerfilTitulo titulo={game.title} perfil={user}/>
        <View  style={styles.containerNota}>
            <Text  style={styles.textoNota}> Nota: {score}/5</Text>
        </View>
        <View style={styles.containerGeral}>
            <Image source={require("@/assets/images/persona5.jpg")} style={styles.imageReview} />
            <Text style={styles.textoReview}>{comment}</Text>
            
        </View>
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
        color: "rgb(255, 255, 255)",
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
        color: "rgb(255, 255, 255)",
        width: 250,
        paddingLeft: 30,
    }
});