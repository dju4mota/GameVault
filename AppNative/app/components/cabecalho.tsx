import {Text, TouchableOpacity, View} from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";
import { StyleSheet } from "react-native";
import { RelativePathString, useRouter } from 'expo-router';
import { useState } from "react";


interface CabecalhoProps{
    activeItem:string,
}


const Cabecalho: React.FC<CabecalhoProps> = ({activeItem}) => {

    const router = useRouter();

    const navega = (route: RelativePathString) => {
        router.push(route);         
    };

    const handleMenuPress = () => {
        console.log('Menu pressionado!');
    };
    

    return (
        <View style={styles.total}>            
            <View style={styles.barraMenus}>
                <TouchableOpacity onPress={handleMenuPress}>
                    <Icon name="menu" size={30} color="rgb(235, 231, 231)" />
                </TouchableOpacity>
                <TouchableOpacity onPress={()=> navega("../screens/searchGame")}>
                    <Icon name="search" size={30} color="rrgb(235, 231, 231)" />
                </TouchableOpacity>
            </View>

            <View style={styles.carrousel}>
                <View style={[styles.textBox, activeItem === 'Jogos' && styles.textBoxBorder]}>
                    <TouchableOpacity onPress={() => navega('../screens/feedGame')}>
                        <Text style={styles.texto}>Jogos</Text>
                    </TouchableOpacity>
                </View>
                <View style={[styles.textBox, activeItem === 'Reviews' && styles.textBoxBorder]}>
                    <TouchableOpacity onPress={() => navega('../screens/feedReview')}>
                        <Text style={styles.texto}>Reviews</Text>
                    </TouchableOpacity>
                </View>
                <View style={[styles.textBox, activeItem === 'Lists' && styles.textBoxBorder]}>
                    <TouchableOpacity onPress={() => navega('../screens/feedList')}>
                        <Text style={styles.texto}>Listas</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>    
    );
}

export default Cabecalho;

const styles = StyleSheet.create({
    total: {
        alignItems: "flex-start",
        flexDirection: 'column',
        backgroundColor: "rgb(255, 72, 0)",
        height: "11%"
    },
    barraMenus:{ 
        paddingRight:20,
        paddingLeft: 10,
        paddingTop: 20,
        justifyContent:"space-between",
        width: "100%",
        flexDirection: "row",
    },
    carrousel:{
        width: "60%",
        flex: 1,        
        justifyContent: "space-around",
        alignItems: "flex-end",
        flexDirection: 'row',
    },
    texto : {
        color: "rgb(255, 255, 255)",
    },
    textBox: {
        alignItems: 'center', 
        marginBottom: 4,
        width: 70,
    },
    textBoxBorder: {
        borderColor: "rgb(0, 0, 0)",
        borderWidth: 4, // Espessura da borda
        borderTopWidth: 0, // Remove a borda superior
        borderLeftWidth: 0, // Remove a borda esquerda
        borderRightWidth: 0, 
        marginBottom: 0,
    }



})
