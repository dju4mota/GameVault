import { View, Text, Image, StyleSheet } from "react-native";
import ContainerPerfil from "./containerPerfil";
import { UserDataInterface } from "../models/UserData";


interface ContainerPerfilTitulo{
    perfil: UserDataInterface;
    titulo: string;
}

const ContainerPerfilTitulo:React.FC<ContainerPerfilTitulo> = ({perfil,titulo}) => {
    return(
        <View style={styles.containerTitulo}>
            <Text style={styles.textoTitulo}>{titulo}</Text>
            <ContainerPerfil userId={perfil.userId} userName={perfil.userName}  userPicture={perfil.userPicture} />
        </View>
    )
}



const styles = StyleSheet.create({     
    containerTitulo:{
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        // backgroundColor: "rgb(10,10,10)",
        marginTop: 30,
        marginLeft: 20,
        marginRight: 10,
        height: 30
    },
    textoTitulo:{
        color: "rgb(255, 255, 255)",
        fontSize: 14
    }    
});

export default ContainerPerfilTitulo;