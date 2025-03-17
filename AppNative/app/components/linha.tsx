import React  from "react";
import { View,TouchableOpacity, StyleSheet} from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";


export default function Linha(){
    return (
        <View style={styles.linha}>

        </View>
    )
}


const styles = StyleSheet.create({
    linha: {
        marginTop: '5%',
        marginLeft: '5%',
        width: '90%',
        height: 2,
        backgroundColor:'rgb(87, 87, 87)',
    }
  });