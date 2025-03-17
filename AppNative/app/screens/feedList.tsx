import React  from "react";
import { View, StyleSheet, ScrollView} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Lista from "../components/list";
import Linha from "../components/linha";


export default function FeedListScreen(){
    
return(
    <View  style={ styles.mainBody}>
        <Cabecalho activeItem={"Lists"}/>      
        <ScrollView>    
            <Lista/>
            <Linha/>
            <Lista/>
            <Linha/>
            <Lista/>
            <Linha/>
            <Lista/>
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