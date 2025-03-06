import React  from "react";
import { View,TouchableOpacity, StyleSheet} from "react-native";
import Icon from "react-native-vector-icons/MaterialIcons";


export default function BotaoPe(){
    return(   
        <View style={{position: 'absolute', left: "80%", right: 20, bottom: 30}}>
            <TouchableOpacity style = {styles.container} >
                <Icon name={"add"} size={30} color="rgb(255, 255, 255)" />
            </TouchableOpacity>
        </View>
    )
}


const styles = StyleSheet.create({
    container: {
        borderWidth:1,
        borderColor:'rgba(0,0,0,0.2)',
        alignItems:'center',
        justifyContent:'center',
        width:65,
        height:65,
        backgroundColor:'rgb(50, 184, 38)',
        borderRadius:100,
    }
  });