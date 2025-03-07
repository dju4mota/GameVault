import React  from "react";
import { View, StyleSheet} from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import Review from "@/app/components/review";


export default function FeedReviewScreen(){
    
return(
    <View  style={ styles.mainBody}>
       <Cabecalho activeItem={"Reviews"}/>       
       <Review/>       
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