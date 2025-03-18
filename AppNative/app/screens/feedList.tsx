import React  from "react";
import { View, StyleSheet, ScrollView} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Lista from "../components/list";
import Linha from "../components/linha";
import PerfilData from "../models/PerfilData";


export default function FeedListScreen(){
    
return(
    <View  style={ styles.mainBody}>
        <Cabecalho activeItem={"Lists"}/>      
        <ScrollView>    
            <Lista fotos={[]} perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")} texto="aaaaaaaaaaaaaaa" />
            <Linha/>
            <Lista fotos={[]} perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")} texto="aaaaaaaaaaaaaaa" />
            <Linha/>
            <Lista fotos={[]} perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")} texto="aaaaaaaaaaaaaaa" />
            <Linha/>
            <Lista fotos={[]} perfil={new PerfilData("joker", "@/assets/images/persona5.jpg")} texto="aaaaaaaaaaaaaaa" />
            <Linha/>    
        </ScrollView>    
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