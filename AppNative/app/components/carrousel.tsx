
import React, { ReactElement, ReactNode } from "react";
import { View, Text, Image, FlatList, StyleSheet, ListRenderItem } from "react-native";
import ContainerPerfil from "./containerPerfil";
import { User } from "../models/UserData";


class CarrouselData {
    foto!: string;
    perfil?: User;
}

interface CarrouselProps {
    texto: string; // Texto (string)
    listaDados: CarrouselData[];        
    hasProfile: boolean;
}

const Carrousel: React.FC<CarrouselProps> = ({texto, listaDados, hasProfile}) => {


    if (hasProfile){

        const renderItem:ListRenderItem<CarrouselData> = ({item}) => (
            <View style={styles.slide}>
                <Image source={require("@/assets/images/persona5.jpg")} style={styles.image} />
                <View style={styles.adicional} >                                        
                    <ContainerPerfil userName={item.perfil!.userName} userPicture={item.perfil!.userPicture} userId={item.perfil!.userId} />
                </View>
            </View>
        );

        return (
            <View style={{ flex: 1 }}>
                <Text style={styles.title}>{texto}</Text>
                <View style={styles.container}>
                    <FlatList
                        data={listaDados}
                        renderItem={renderItem}
                        horizontal
                        
                        showsHorizontalScrollIndicator={false}
                    />
                </View>
            </View>
        )
    } else { 
    
        const renderItem:ListRenderItem<CarrouselData> = ({item}) => (
            <View style={styles.slide}>
                <Image source={require("@/assets/images/persona5.jpg")} style={styles.image} />
            </View>
        );
    
        return (
            <View style={{ flex: 1 }}>
                <Text style={styles.title}>{texto}</Text>
                <View style={styles.containerMenor}>
                    <FlatList
                        data={listaDados}
                        renderItem={renderItem}
                        horizontal
                        showsHorizontalScrollIndicator={false}
                    />
                </View>
            </View>
        )

    }
}

export default Carrousel;


const styles = StyleSheet.create({
    adicional:{
        flexDirection: "row",
        justifyContent:"flex-start",
        alignContent: "center",
        width: "80%",
        marginTop: 10,
        //backgroundColor: "rgb(255,255,255)"
    },
    adicionalTexto:{
        paddingLeft: 5,
        fontSize: 15,
        color: "rgb(226, 226, 226)",
    },
    adicionalFoto:{
        height:30,
        width:30,
        borderRadius: 30,
    },
    container: {
        justifyContent: "flex-start",
        alignItems: "flex-start",
        height: 200,
        marginLeft: 20,
        // backgroundColor: "rgb(255,255,255)"
    },
    containerMenor: {
        justifyContent: "flex-start",
        alignItems: "flex-start",
        height: 160,
        marginLeft: 20,
        // backgroundColor: "rgb(255,255,255)"
    },
    slide: {
        width: 170,
        justifyContent: "center",
        alignItems: "center",
        margin:0,
    },
    image: {
        width: 150,
        height: 150,
        margin:0,
    },
    title: {
        marginTop: 20,
        marginLeft: 35,
        marginBottom: 10,
        fontSize: 18,
        fontWeight: "bold",
        color: "rgb(226, 226, 226)",
    },
});