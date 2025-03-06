import React, { useEffect, useState }  from "react";
import { View, Text, Image, FlatList, StyleSheet, Dimensions } from "react-native";
import Cabecalho from "@/app/components/cabecalho";
import axios from 'axios';
import Carrousel from "@/app/components/carrousel";


export default function FeedScreen(){
return(
    <View style={{ flex: 1,        
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
       </View>
       {/* <API/> */}
   </View>
)

}