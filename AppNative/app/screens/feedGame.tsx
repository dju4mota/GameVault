import React  from "react";
import { View, StyleSheet} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Carrousel from "@/app/components/carrousel";
import BotaoPe from "@/app/components/botaoPe";
import { User } from "../models/UserData";



export default function FeedGameScreen(){
    
    const lista = [
    {
        foto: "@/assets/images/persona5.jpg",
        perfil: new User("","joker", "@/assets/images/persona5.jpg")
    },
    {
        foto: "@/assets/images/persona5.jpg",
        perfil: new User("","joker", "@/assets/images/persona5.jpg")
    },
    {
        foto: "@/assets/images/persona5.jpg",
        perfil: new User("","joker", "@/assets/images/persona5.jpg")
    },
    {
        foto: "@/assets/images/persona5.jpg",
        perfil: new User("","joker", "@/assets/images/persona5.jpg")
    }
];


return(
    <View  style={ styles.mainBody}>
       <Cabecalho activeItem={"Jogos"}/>
       <View  style={styles.carrousel}>
           <Carrousel texto={"Popular"} hasProfile={false} listaDados={lista } />
           <Carrousel texto={"Entre amigos"} hasProfile={true} listaDados={lista}/>           
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