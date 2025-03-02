import React, { useEffect, useState }  from "react";
import { View, Text, Image, FlatList, StyleSheet, Dimensions } from "react-native";
import {Cabecalho} from "@/app/components/cabecalho";
import axios from 'axios';

const { width: screenWidth } = Dimensions.get("window");

// const images = [
//     { id: 1, source: require("../../assets/images/persona5/jpg"), title: "Persona 5" },
//     { id: 2, source: require("../../assets/images/persona5.jpg"), title: "Persona 4" },
//     { id: 3, source: require("../../assets/images/persona5.jpg"), title: "Persona 3" },
// ];

export default function Index() {
    return (
        <View style={{ flex: 1 }}>
            <Cabecalho />
            {/* <Carrousel/> */}
            <API/>
        </View>
    );
}


// function Carrousel(){
//     const renderItem = () => (
//         <View style={styles.slide}>
//             {/* <Image source={require("../../assets/images/persona5.jpg")} style={styles.image} /> */}
//         </View>
//     );
//     return (
//         <View style={{ flex: 1 }}>
//             <Text style={styles.title}>Popular essa semana</Text>
//             <View style={styles.container}>
//                 <FlatList
//                     data={images}
//                     renderItem={renderItem}
//                     horizontal
//                     showsHorizontalScrollIndicator={false}
//                 />
//             </View>
//         </View>
//     )
// }

const styles = StyleSheet.create({
    container: {
        justifyContent: "center",
        alignItems: "center",
        height: 160,
        marginLeft: 20,
    },
    slide: {
        width: 170,
        justifyContent: "center",
        alignItems: "center",
        margin:0,
    },
    image: {
        width: 150,
        height: 150,
        margin:0,
    },
    title: {
        marginTop: 50,
        marginLeft: 20,
        marginBottom: 20,
        fontSize: 18,
        fontWeight: "bold",
        color: "#333",
    },
});


function API() {
    const [message, setMessage] = useState('');
  
    useEffect(() => {
      const apiUrl = 'http://192.168.18.149:8080/reviews';
  
      axios.get(apiUrl)
        .then(response => {
          setMessage(response.data);
          console.log(response.data)
        })
        .catch(error => {
          console.error('Erro ao buscar dados:', error);
        });
    }, []);
  
    return (
      <View>
        {/* <Text>Resposta da API: {message}</Text> */}
      </View>
    );
  };
  
