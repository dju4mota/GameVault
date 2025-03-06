import React  from "react";
import { View, StyleSheet} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Carrousel from "@/app/components/carrousel";
import BotaoPe from "@/app/components/botaoPe";


export default function FeedReviewScreen(){
    
return(
    <View  style={ styles.mainBody}>
       <Cabecalho/>              
   </View>
    )
}


const styles = StyleSheet.create({
    carrousel: {
        // flex:1,
        justifyContent: "space-between",
        height: "60%",
        // backgroundColor: "#000"
    },
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)"  
    }
  });