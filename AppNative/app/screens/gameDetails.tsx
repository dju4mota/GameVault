
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Text,Image, ScrollView, Button} from "react-native";
import { useLocalSearchParams } from 'expo-router';
import Linha from '../components/linha';
import { GameData } from '../models/GameData';


// const GameDetails :React.FC<GameData> = ({ game}) => {
const GameDetails = () => {
    const params = useLocalSearchParams();
    const response: GameData = JSON.parse(params.game as string);
    
    return(
        <View style={styles.mainBody}>
            <View style={styles.containerGeral}>
                <View style={styles.containerTitulo}>            
                    {/* <ContainerPerfil userId={response.user.userId} userPicture={response.user.userPicture} userName={response.user.userName}></ContainerPerfil> */}
                    <Text style={styles.textoTitulo}>{response.title}</Text>
                    <Text style={styles.textoGenero}>{response.genre}</Text>
                    {/* To Do média de votos */}
                    <Text style={styles.textoNota}>Média: 3/10</Text>
                </View>
                <Image source={require("@/assets/images/persona5.jpg")} style={styles.imageReview} />            
            </View>            
            <Text style={styles.textoReview}>{response.description}</Text>
            <Linha></Linha>
            <View style={styles.containerRecomendado}>
                <Text style={styles.textoTitulo}>Jogado por:</Text>            
            </View>
        </View>
    );    
}


export default GameDetails;



const styles = StyleSheet.create({
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)",          
    },     
    containerTitulo:{
        justifyContent: 'space-around',
        width: '50%'
    },
    containerRecomendado:{
        padding:20
    },        
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 20
    },    
    textoGenero:{
        color: "rgba(255, 255, 255, 0.51)",
        fontSize: 15
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