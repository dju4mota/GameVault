import React, { useEffect, useState }  from "react";
import { View} from "react-native";
import axios from 'axios';
import FeedScreen from "./screens/feedGame";


export default function Index() {
    return (
        <FeedScreen/>
    );
}


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
  
