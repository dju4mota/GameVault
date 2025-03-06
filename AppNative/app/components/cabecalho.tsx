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
                    <Icon name="menu" size={30} color="#000" />
                </TouchableOpacity>
                <TouchableOpacity onPress={handleMenuPress}>
                    <Icon name="search" size={30} color="#000" />
                </TouchableOpacity>
            </View>

            <View style={styles.carrousel}>
                <Text>Jogos</Text>
                <Text>Reviews</Text>
                <Text>Listas</Text>
            </View>

        </View>
    
    );
}

const styles = StyleSheet.create({
    total: {
        alignItems: "flex-start",
        flexDirection: 'column',
        backgroundColor: "#777",
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
    }



})