import React, { useEffect, useState }  from "react";
import { View, Text, Image, FlatList, StyleSheet, Dimensions, Button } from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import axios from 'axios';
import Carrousel from "@/app/components/carrousel";


export default function FeedScreen(){
    const handleMenuPress = () => {
        console.log('Menu pressionado!');
    };
return(
    <View style={{ flex: 1,      
        backgroundColor: "rgb(36, 36, 36)"  
    }}>
       <Cabecalho />
       <View
            style={{
                // flex:1,
                justifyContent: "space-around",
                height: "60%",
                // backgroundColor: "#000"
            }}>
           <Carrousel/>
           <Carrousel/>
           <Button
                onPress={handleMenuPress}
                title="+"
                color="rgb(76, 151, 14)"                
                />
       </View>
       {/* <API/> */}
   </View>
)

}