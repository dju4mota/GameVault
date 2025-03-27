
import React, { useEffect, useState } from 'react';
import { View, StyleSheet, Text,Image, ScrollView, Button, TextInput} from "react-native";
import { GameData } from '../models/GameData';
import Linha from '../components/linha';
import Game from '../components/game';
import { ApiService } from '@/services/ApiService';


const SearchGame = () => {
    const [searchText, setSearchText] = useState('');
    const [games, setGames] = useState<GameData[]>([]);
    
    const search = async (title: string) => {
        try {
            const data = await ApiService.get(0,ApiService.rotas.GamesByName + "title"); 
            setGames(data); 
        } catch (error) {
            console.error('Erro ao buscar jogo por nome ' + title +" - " , error);
        }
    }
        
    

    return(
        <View style={styles.mainBody}>
            <TextInput
                style={styles.containerInput}
                placeholder="Digite o jogo para buscar"
                value={searchText}
                onChangeText={setSearchText}
                onSubmitEditing={() => search(searchText)} // Chamado ao pressionar "Enter"
            />
           <ScrollView>
                {games.map((game, index) => (                    
                    <React.Fragment key={index}>
                        <Game                                                    
                            description={game.description} gameId={game.gameId} title={game.title} genre={game.genre} photo={game.photo}/>
                        <Linha/>
                    </React.Fragment>
                ))}
            </ScrollView>
        </View>
    );    
}


export default SearchGame;



const styles = StyleSheet.create({
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)",          
    },
    containerInput:{
        padding:20,
        backgroundColor : "rgb(255, 254, 254)",          
    }
});