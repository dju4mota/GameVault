import React  from "react";
import { View, StyleSheet} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Carrousel from "@/app/components/carrousel";
import BotaoPe from "@/app/components/botaoPe";


export default function FeedGameScreen(){
    
return(
    <View  style={ styles.mainBody}>
       <Cabecalho activeItem={"Jogos"}/>
       <View  style={styles.carrousel}>
           <Carrousel texto={"Popular"}/>
           <Carrousel texto={"Entre amigos"} nome="dju" foto="hell yeah"/>           
       </View>  
       <BotaoPe/>
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