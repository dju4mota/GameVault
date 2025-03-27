
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Text,Image, ScrollView, Button} from "react-native";
import { ReviewData } from '../models/ReviewData';
import { useLocalSearchParams } from 'expo-router';
import { ResponseDTO } from '../models/dto/ResponseDto';
import ContainerPerfil from '../components/containerPerfil';
import Linha from '../components/linha';


// const ReviewDetails :React.FC<ReviewData> = ({ reviewId, score, comment, data, platform, hoursPlayed, user, game}) => {
const ReviewDetails = () => {
    const params = useLocalSearchParams();
    const response: ResponseDTO = JSON.parse(params.review as string);
    
    return(
        <View style={styles.mainBody}>
            <View style={styles.containerGeral}>
                <View style={styles.containerTitulo}>            
                    <ContainerPerfil userId={response.user.userId} userPicture={response.user.userPicture} userName={response.user.userName}></ContainerPerfil>
                    <Text style={styles.textoTitulo}>{response.game.title}</Text>
                    <Text style={styles.textoNota}>{response.review.score}/10</Text>
                </View>
                <Image source={require("@/assets/images/persona5.jpg")} style={styles.imageReview} />            
            </View>            
            <Text style={styles.textoReview}>{response.review.comment}</Text>
            <Linha></Linha>
        </View>
    );    
}


export default ReviewDetails;



const styles = StyleSheet.create({
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)",          
    },     
    containerTitulo:{
        justifyContent: 'space-around'
    },        
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 20
    },    
    textoNota:{
        fontSize: 15,
        color: "rgb(248, 188, 120)",
    },
    imageReview:{
        // paddingTop: 50,
        width: 120,
        height: 150,
        marginTop: 10,        
    },
    containerGeral:{
        flexDirection: "row",
        justifyContent: "space-around",
        paddingTop: 25,        
    },
    textoReview:{
        color: "rgb(160, 158, 158)",
        width: 250,
        paddingLeft: 30,
        paddingTop: 35,
        fontSize: 20,
    }
});