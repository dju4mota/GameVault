import React  from "react";
import { View, StyleSheet, ScrollView} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";
import Linha from "../components/linha";


export default function FeedReviewScreen(){
    
return(
    <View  style={ styles.mainBody}>
        <Cabecalho activeItem={"Reviews"}/>       
        <ScrollView>
            <Review/>       
            <Linha/>
            <Review/>       
            <Linha/>
            <Review/>      
            <Linha/>
            <Review/>       
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
        backgroundColor: "rgb(36, 36, 36)",  
        
    }
  });