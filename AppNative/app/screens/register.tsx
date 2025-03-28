
import React, {useState } from 'react';
import { View, StyleSheet, Button, TextInput} from "react-native";


const Login = () => {
    const [userName, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function register(){        
        
    }


    return (
        <View style={styles.mainBody}>
            
            <TextInput
                style={styles.containerInput}
                placeholder="Nome"
                value={userName}
                onChangeText={setUsername}
                //onSubmitEditing={login}
            />
            <TextInput
                style={styles.containerInput}
                placeholder="Senha"
                value={password}
                onChangeText={setPassword}
                //onSubmitEditing={login}
            />
            <View style={styles.buttonContainer}>
                <Button color={"rgb(221, 73, 15)"} title='Cadastrar' onPress={register}></Button>
            </View>
        </View>
    )
}

export default Login

const styles = StyleSheet.create({
    mainBody: {
        flex: 1,      
        backgroundColor: "rgb(36, 36, 36)",          
        justifyContent: "center",
        alignItems: "center"
        
    },
    containerInput:{
        padding:10,
        marginBottom:40,
        width: "60%",
        backgroundColor : "rgb(207, 207, 207)",          
    },
    buttonContainer:{
        width: "50%"
    }

});