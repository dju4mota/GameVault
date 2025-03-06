import {Text, TouchableOpacity, View} from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";
import { StyleSheet } from "react-native";

export default function Cabecalho() {
    const handleMenuPress = () => {
        console.log('Menu pressionado!');
    };
    return (
        <View style={styles.total}>
            
            <View style={styles.barraMenus}>
                <TouchableOpacity onPress={handleMenuPress}>
                    <Icon name="menu" size={30} color="rgb(235, 231, 231)" />
                </TouchableOpacity>
                <TouchableOpacity onPress={handleMenuPress}>
                    <Icon name="search" size={30} color="rrgb(235, 231, 231)" />
                </TouchableOpacity>
            </View>

            <View style={styles.carrousel}>
                <Text style={styles.texto}>Jogos</Text>
                <Text style={styles.texto}>Reviews</Text>
                <Text style={styles.texto}>Listas</Text>
            </View>

        </View>
    
    );
}

const styles = StyleSheet.create({
    total: {
        alignItems: "flex-start",
        flexDirection: 'column',
        backgroundColor: "rgb(255, 72, 0)",
        height: "12%"
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
        width: "70%",
        flex: 1,        
        justifyContent: "space-around",
        alignItems: "center",
        flexDirection: 'row',
        // backgroundColor: "#222",
    },
    texto : {
        color: "rgb(255, 255, 255)"
    }



})